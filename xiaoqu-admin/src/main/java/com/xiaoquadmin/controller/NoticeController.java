package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.NoticeService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
@Api(value = "/notice", tags = {"公告相关接口"})
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/add")
    public R add(@RequestBody Notice notice){
        boolean save = noticeService.save(notice);
        if (save) {
            return new R();
        }else {
            return new R(20001, "保存异常");
        }
    }

    @PostMapping("/update")
    public R update(@RequestBody Notice notice){
        boolean save = noticeService.updateById(notice);
        if (save) {
            return new R();
        }else {
            return new R(20001, "修改异常");
        }
    }


    @GetMapping("/delete")
    public R delete(int id){
        boolean save = noticeService.removeById(id);
        if (save) {
            return new R();
        }else {
            return new R(20001, "修改异常");
        }
    }

    @GetMapping("/getById")
    public R getById(int id){
        return new R(noticeService.getById(id));
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<Notice> noticePage = new Page<>(pageNum, pageSize);
        QueryWrapper<Notice> query = Wrappers.<Notice>query();
        query.orderByDesc("id");
        Page<Notice> page = noticeService.page(noticePage, query);
        return new R(page);
    }


    @GetMapping("/search")
    public R search(int pageNum, int pageSize, String matchStr){
        QueryWrapper<Notice> query = Wrappers.<Notice>query();
        query.like("no_text", matchStr).orderByDesc("id");
        Page<Notice> noticePage = new Page<>(pageNum, pageSize);
        Page<Notice> page = noticeService.page(noticePage, query);
        return new R(page);
    }

}
