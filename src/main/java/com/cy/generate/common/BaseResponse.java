package com.cy.generate.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/18 15:49
 */
public class BaseResponse extends HashMap<Object, Object> {

    public BaseResponse() {
        super();
        this.setSuccess(false);
    }

    public BaseResponse(boolean success) {
        super();
        this.setSuccess(success);
    }

    public void setSuccess(boolean success) {
        this.put("success", success);
    }

    public void setError(ErrorCode code) {
        Map error = new HashMap();
        error.put("code", code.getCode());
        error.put("msg", code);
        error.put("message", code.getMessage());
        this.put("error", error);
    }

    public void setMsg(String msg) {
        this.put("msg", msg);
    }
    

}
