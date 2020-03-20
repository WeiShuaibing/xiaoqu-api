package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.LogService;
import com.xiaoquadmin.service.NoticeService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Log;
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
    @Autowired
    private AdminService adminService;
    @Autowired
    private LogService logService;

    @PostMapping("/add")
    public R add(@RequestBody Notice notice, @RequestHeader int YQYJToken){
        boolean save = noticeService.save(notice);
        Admin byId = adminService.getById(YQYJToken);
        if (save) {
            logService.save(new Log(byId.getAdminName(), "新增公告->" + notice.getNoText(), "success"));
            return new R();
        }else {
            logService.save(new Log(byId.getAdminName(), "新增公告->" + notice.getNoText(), "保存异常!"));
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
    public R delete(int id, @RequestHeader int YQYJToken){

        Notice del_notice = noticeService.getById(id);
        boolean save = noticeService.removeById(id);
        Admin byId = adminService.getById(YQYJToken);

        if (save) {
            logService.save(new Log(byId.getAdminName(), "删除公告->"+del_notice.getNoText(), "success"));
            return new R();
        }else {
            logService.save(new Log(byId.getAdminName(), "删除公告->"+del_notice.getNoText(), "删除失败！"));
            return new R(20001, "删除失败！");
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
