package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 缴费单实体类
 */
@Data
public class Payorder {

    @TableId(type = IdType.AUTO)
    private int id;

    private String payText;
    private String payRemark;
    private float payMoney;
    private Date payEnddate;

    private int payType;  // 1物业，2停车 3水 4电

    private Integer userId; // 缴费单针对的用户

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
