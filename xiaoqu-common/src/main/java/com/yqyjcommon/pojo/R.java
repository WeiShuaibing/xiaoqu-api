package com.yqyjcommon.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

/**
 * 前后端交互实体类
 */
@Data
public class R{

    private int code = 20000;

    private String msg = "success";

    private Object data;

    public R(){}

    public R(Object data){
        this.data = data;
    }

    public R(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
