package com.cy.generate.common;

/**
 * @author: codeyung  E-mail:yjc199308@gmail.com
 * @date: 2020-08-18.21:47
 */
public class ResponseTest {

    public static void main(String[] args) {
        String data = "data";
        BaseResponse response = new BaseResponse();
        System.out.println(response);
        response = new BaseResponse(data);
        System.out.println(response);
        response = new BaseResponse(data,"带数据");
        System.out.println(response);
        response = new BaseResponse(new RuntimeException("详细异常信息"),ErrorCode.EXCEPTION);
        System.out.println(response);
        response = new BaseResponse(new Exception("未知"),ErrorCode.UNKNOW);
        System.out.println(response);

        System.out.println(response.isSuccess());
        response = new BaseResponse(data);
        System.out.println(response.getData());
    }

}
