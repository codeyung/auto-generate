//package com.cy.generate.common.builder;
//
//import com.cy.generate.common.util.GsonUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description:
// * @Author: YongJingChuan
// * @Date: 2020/9/6 16:09
// */
//public class RedisCacheService {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheService.class);
//    private static final String STR_SUCCESS = "OK";
//    private static final int INT_SUCCESS = 1;
//
//    private RedisTemplate redis;
//
//    /**
//     * 设置缓存信息
//     *
//     * @param key
//     * @param object
//     */
//    public boolean set(String key, Object object) {
//        try {
//            String json = GsonUtils.toJson(object);
//            return STR_SUCCESS.equals(redis.set(key, json));
//        } catch (Exception e) {
//            LOGGER.error("set 出错", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param key
//     * @param object
//     * @param seconds
//     * @return
//     */
//    public boolean setex(String key, Object object, int seconds) {
//        try {
//            String json = GsonUtils.toJson(object);
//            return STR_SUCCESS.equals(redis.setex(key, seconds, json));
//        } catch (
//                Exception e) {
//            LOGGER.error("setex 出错", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param key
//     * @param object
//     * @return
//     */
//    public boolean setnx(String key, Object object) {
//        try {
//            String json = GsonUtils.toJson(object);
//            return INT_SUCCESS == redis.setnx(key, json);
//        } catch (Exception e) {
//            LOGGER.error("setnx 出错", e);
//        }
//        return false;
//    }
///**
// * @param key
// * @param object
// * @param seconds
// * @return
// */
//public boolean setnxex(String key, Object object, int seconds) {
//        try {
//        String json = GsonUtils.toJson(object);
//        return STR_SUCCESS.equals(redis.set(key, json, "NX", "EX", seconds));
//        } catch (Exception e) {
//        LOGGER.error("setex 出错", e);
//        }
//        return false;
//        }
//
//    /**
//     * @param key
//     * @return
//     */
//    public String get(String key) {
//        try {
//            return redis.get(key);
//        } catch (Exception e) {
//            LOGGER.error("get 出错", e);
//        }
//        return null;
//    }
//
//    /**
//     * @param key
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public <T> T get(String key, Class<T> type) {
//        String objectJson = this.get(key);
//        if (StringUtils.isBlank(objectJson)) {
//            return null;
//        }
//        return GsonUtils.fromJson(objectJson, type);
//    }
//
//    /**
//     * @param key
//     * @param field
//     * @param obj
//     */
//    public boolean hset(String key, String field, Object obj) {
//        try {
//            String json = GsonUtils.toJson(obj);
//            redis.hset(key, field, json);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("hset 出错", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param key
//     * @param field
//     * @param obj
//     * @param seconds
//     */
//    public boolean hsetex(String key, String field, Object obj, int seconds) {
//        try {
//            String json = GsonUtils.toJson(obj);
//            redis.hset(key, field, json);
//            redis.expire(key, seconds);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("hsetex 出错", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param key
//     * @param field
//     * @param obj
//     * @param seconds
//     */
//    public boolean hsetnx(String key, String field, Object obj, int seconds) {
//        try {
//            String json = GsonUtils.toJson(obj);
//            redis.hsetnx(key, field, json);
//            redis.expire(key, seconds);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("hsetnx 出错", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param key
//     * @param field
//     * @param type
//     * @param <T>
//     * @return
//     */
//    public <T> T hget(String key, String field, Class<T> type) {
//        try {
//            String json = redis.hget(key, field);
//            if (StringUtils.isBlank(json)) {
//                return null;
//            }
//            return GsonUtils.fromJson(json, type);
//        } catch (Exception e) {
//            LOGGER.error("hget 出错", e);
//        }
//        return null;
//    }
//
//    /**
//     * @param key
//     * @param field
//     * @return
//     */
//    public String hget(String key, String field) {
//        try {
//            return redis.hget(key, field);
//        } catch (Exception e) {
//            LOGGER.error("hget 出错", e);
//        }
//        return null;
//    }
//
///**
// * @param key
// * @param type
// * @param fields
// * @param <T>
// * @return
// */
//public <T> List<T> hmget(String key, Class<T> type, String... fields) {
//        List<T> list = new ArrayList<>();
//        try {
//        List<String> values = redis.hmget(key, fields);
//        values.forEach(value -> list.add(GsonUtils.toBean(value, type)));
//        return list;
//        } catch (Exception e) {
//        LOGGER.error("hget 出错", e);
//        }
//        return null;
//        }
///**
// * @param key
// * @param pattern
// * @param count
// * @return
// */
//public List<String> hscan(String key, String pattern, int count) {
//        String cursor = STR_CURSOR;
//        List<String> keys = new ArrayList<>();
//        try {
//        while (true) {
//        ScanResult<Map.Entry<String, String>> scanResult =
//        redis.hscan(key, cursor, new ScanParams().match(pattern).count(count));
//        cursor = scanResult.getCursor();
//        List<Map.Entry<String, String>> list = scanResult.getResult();
//        if (CollectionUtils.isNotEmpty(list)) {
//        list.forEach(entry -> keys.add(entry.getValue())
//        );
//        }
//        if (cursor.equals(STR_CURSOR)) {
//        break;
//        }
//        }
//        } catch (Exception e) {
//        LOGGER.error("hscan 出错", e);
//        return null;
//        }
//        return keys;
//        }
//
//    /**
//     * @param key
//     * @return
//     */
//    public boolean exists(String key) {
//        try {
//            return redis.exists(key);
//        } catch (Exception e) {
//            LOGGER.error("exists 出错", e);
//        }
//        return false;
//    }
//
//
//    /**
//     * @param key
//     * @return
//     */
//    public boolean del(String key) {
//        try {
//            redis.del(key);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("del 出错", e);
//        }
//        return false;
//    }
//
//
//    /**
//     * @param lockKey
//     * @param requestId
//     * @param seconds
//     * @return
//     */
//    public boolean revLock(String lockKey, String requestId, int seconds) {
//        try {
//            /**
//             *  EX second ：设置键的过期时间为 second 秒。 SET key value EX second 效果等同于 SETEX key second value 。
//             *	PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value 。
//             *	NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value 。
//             *	XX ：只在键已经存在时，才对键进行设置操作。
//             */
//            //毫秒
//            int millisecond = seconds * 1000;
//            return STR_SUCCESS.equals(redis.set(lockKey, requestId, "NX", "PX", millisecond));
//        } catch (Exception e) {
//            LOGGER.error("revLock 出错!", e);
//        }
//        return false;
//    }
//
//    /**
//     * @param lockKey
//     * @param requestId
//     * @return
//     */
//    public boolean releaseLock(String lockKey, String requestId) {
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        try {
//            return STR_SUCCESS.equals(redis.eval(script, lockKey, requestId));
//        } catch (RuntimeException re) {
//            LOGGER.error("releaseLock 释放锁发生异常,由redis有效期自动处理,本次认为释放成功", re);
//            return true;
//        }
//    }
//
//}
