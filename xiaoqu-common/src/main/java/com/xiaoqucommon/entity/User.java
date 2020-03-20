package com.xiaoqucommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    @TableId(type = IdType.AUTO)
    private int id;
    private Integer buId; // 所属楼房
    private String userName;
    private String userPhone;
    private String userPassword;
    private String userSex;
    private int userAge;
    private String userAvatar = "https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80";
    private String userRemark;
    private String roles = "user";

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间


}
