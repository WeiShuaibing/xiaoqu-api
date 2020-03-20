package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.LogService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Log;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
@Api(value = "/user", tags = {"日志相关接口"})
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize){
        QueryWrapper<Log> query = Wrappers.<Log>query();
        query.orderByDesc("id");

        Page<Log> logPage = new Page<>(pageNum, pageSize);
        Page<Log> page = logService.page(logPage, query);
        return new R(page);
    }

}
