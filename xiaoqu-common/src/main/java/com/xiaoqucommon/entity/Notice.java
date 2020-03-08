package com.xiaoqucommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    @TableId(type = IdType.AUTO)
    private int id;

    private String noText;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date noEnddate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
