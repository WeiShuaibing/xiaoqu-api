package com.xiaoqucommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Log {

    @TableId(type = IdType.AUTO)
    private int id;
    private String user;
    private String operation;
    private String operationStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date; //创建时间


    public Log(){}

    public Log(String user, String operation, String operationStatus) {
        this.user = user;
        this.operation = operation;
        this.operationStatus = operationStatus;
    }

}
