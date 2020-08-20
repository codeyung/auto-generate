package com.cy.generate.thread;

import com.cy.generate.GenerateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GenerateApplication.class})
public class ThreadLocalTest {

    @Autowired
    private ThreadA threadA;
    @Autowired
    private ThreadB threadB;

    @Test
    public void test() throws Exception {
        Thread thread1 = new Thread(() -> {
            threadA.setValue("AAAA");
            while (true) {
                threadA.getValue();
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            threadB.setValue("BBBB");
//            threadA.setValue("BBBB");
            while (true) {
//                threadA.getValue();
                threadB.getValue();
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public void testConcurrent() throws InterruptedException {

        //执行次数
//        int clientTotal = 100;
        int clientTotal = 10;
        // 同时并发执行的线程数
//        int threadTotal = 5;
        int threadTotal = 2;
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        AtomicInteger falg = new AtomicInteger();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();
                    falg.getAndIncrement();

                    if (falg.get() % 2 == 0) {
                        test();
                    } else {
                        test();
                    }

                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                    e.printStackTrace();

                }
                //闭锁减一
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();
    }


}
