package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = {"用户相关接口"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        MyPage<Map<String, Object>> page = userService.getPage(pageNum, pageSize);
        return new R(page);
    }

    @PostMapping("/add")
    public R add(@RequestBody User user) {

        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("user_phone", user.getUserPhone());
        User one = userService.getOne(query);
        if (one != null) {
            return new R(20002, "手机号已经存在！");
        }

        boolean b = userService.save(user);
        if (b) return new R();
        else return new R(20001, "添加失败！");
    }

    @GetMapping("/getById")
    public R getById(int id){
        User byId = userService.getById(id);
        return new R(byId);
    }

    @GetMapping("/delete")
    public R delete(int id){
        boolean b = userService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody User user){
        boolean b = userService.updateById(user);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }

    @GetMapping("/search")
    public R search(int pageNum, int pageSize, String matchStr) {
        return new R(userService.search(pageNum, pageSize, matchStr));
    }

    @GetMapping("/searchByName")
    public R searchByName(String matchStr) {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.like("user_name", matchStr);
        List<User> list = userService.list(query);
        return new R(list);
    }

}
