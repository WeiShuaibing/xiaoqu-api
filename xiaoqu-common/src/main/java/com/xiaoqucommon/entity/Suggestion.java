package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 投诉建议实体类
 */
@Data
public class Suggestion {

    @TableId(type = IdType.AUTO)
    private int id;
    private Integer userId; // 投诉建议用户的id
    private String suText;
    private String suImgs;
    private int suStatus; //投诉，建议的状态  1 发起投诉，2 收到投诉，3 已处理投诉

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
