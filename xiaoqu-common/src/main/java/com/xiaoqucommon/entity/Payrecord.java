package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 缴费记录表实体类
 */
@Data
public class Payrecord {

    @TableId(type = IdType.AUTO)
    private int id;

    private Integer payorderId; // 缴费单id
    private Integer userId; //用户id
    private Integer payorderStatus; //订单完成状态  1完成支付，2未完成支付

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
