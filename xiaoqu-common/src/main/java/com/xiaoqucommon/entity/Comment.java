package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * 评论实体类
 */
@Data
public class Comment {

    @TableId(type = IdType.AUTO)
    private int id;
    private Integer topicId;
    private String commentText;
    private String commentImg;
    private Integer userId; // 创建话题的用户
    private Integer commentParentId;

    private Integer commentLove; // 点赞数

    @TableField(exist = false)
    private Object children;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
