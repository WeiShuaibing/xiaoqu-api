package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 停车位实体类
 */
@Data
public class Car {

    @TableId(type = IdType.AUTO)
    private int id;
    private Integer userId; // 停车位所属的用户
    private float carLong;
    private float carWidth;
    private String carRemark;
    private String carAddr;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
