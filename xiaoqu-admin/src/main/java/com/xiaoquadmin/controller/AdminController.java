package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.LogService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Log;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(value = "/admin", tags = {"管理员相关接口"})
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private LogService logService;

    @PostMapping("/login")
    public R login(@RequestBody Admin admin){
        R r = adminService.verifyLogin(admin);
        return r;
    }

    /**
     * 获取用户基本信息
     * @return
     */
    @GetMapping("/info")
    public R info(@RequestHeader String YQYJToken){
        return new R(adminService.getById(YQYJToken));
    }

    @GetMapping("/logout")
    public R logout(){

        return new R();
    }

    @PostMapping("/add")
    public R add(@RequestBody Admin admin, @RequestHeader int YQYJToken){

        Admin admin_phone = adminService.getOne(Wrappers.<Admin>query().eq("admin_phone", admin.getAdminPhone()));
        if (admin_phone!= null) {
            return new R(20001,"手机号/账号已存在！");
        }

        boolean b = adminService.save(admin);
        Admin byId = adminService.getById(YQYJToken);
        if (b) {
            logService.save(new Log(byId.getAdminName(), "新增管理员->" + admin.getAdminName(), "success"));
            return new R();
        } else {
            logService.save(new Log(byId.getAdminName(), "新增管理员->" + admin.getAdminName(), "新怎管理员失败！"));
            return new R(20001, "保存失败！");
        }
    }

    @GetMapping("/getall")
    public R getAllAdmin(){
        List<Admin> list = adminService.list();
        R r = new R(list);
        return r;
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<Admin> adminPage = new Page<>(pageNum, pageSize);
        Page<Admin> page = adminService.page(adminPage);
        return new R(page);
    }

    @GetMapping("/delete")
    public R delete(int id, @RequestHeader int YQYJToken) {

        Admin delete_admin = adminService.getById(id);
        Admin byId = adminService.getById(YQYJToken);
        boolean b = adminService.removeById(id);
        if (b) {
            logService.save(new Log(byId.getAdminName(), "删除管理员->" + delete_admin.getAdminName(), "success"));
            return new R();
        } else {
            logService.save(new Log(byId.getAdminName(), "删除管理员->" + delete_admin.getAdminName(), "服务异常，删除失败！"));
            return new R(20001,"服务异常，删除失败！");
        }
    }

    @GetMapping("/getById")
    public R getById(int id) {
        Admin admin = adminService.getById(id);
        return new R(admin);
    }

    @PostMapping("/update")
    public R update(@RequestBody Admin admin) {
        boolean b = adminService.updateById(admin);
        if (b) return new R();
        else return new R(20001,"服务遗产，更新失败！");
    }

    @GetMapping("/search")
    R search(int pageNum, int pageSize, String matchStr){
        QueryWrapper<Admin> query = Wrappers.<Admin>query();
        query.like("admin_name", matchStr);
        Page<Admin> adminPage = new Page<>(pageNum, pageSize);
        Page<Admin> page = adminService.page(adminPage, query);
        return new R(page);
    }

}
