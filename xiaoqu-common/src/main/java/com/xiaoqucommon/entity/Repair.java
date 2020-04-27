package com.xiaoqucommon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class Repair {

    @TableId(type = IdType.AUTO)
    private int id;
    private Integer userId; // 投诉建议用户的id
    private String repairText;
    private String repairImgs;
    private Integer repairStatus; //投诉，建议的状态  1 发起维修，2 收到维修，3 维修完毕

    private Integer repairEvaluate; // 评分
    private String repairEvaluateText; // 评语

    private Integer adminId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

}
