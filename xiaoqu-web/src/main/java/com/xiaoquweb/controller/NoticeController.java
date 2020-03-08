package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.NoticeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notice")
@Api(value = "/notice", tags = {"通知相关接口"})
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @GetMapping("/getById")
    public R getById(int id) {
        Notice byId = noticeService.getById(id);
        return new R(byId);
    }

    @GetMapping("/getAll")
    public R getAll(){
        QueryWrapper<Notice> query = Wrappers.<Notice>query();
        query.ge("no_enddate",new Date());
        List<Notice> list = noticeService.list(query);
        return new R(list);
    }


}
