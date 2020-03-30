package com.xiaoquweb.controller;


import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = {"用户相关接口"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        R r = userService.verifyLogin(user);
        return r;
    }

    /**
     * 获取用户基本信息
     * @return
     */
    @GetMapping("/info")
    public R info(@RequestHeader String YQYJToken){
        return new R(userService.getById(YQYJToken));
    }

    @GetMapping("/infoForStore")
    public R infoForStore(@RequestHeader String YQYJToken){
        User db_user = userService.getById(YQYJToken);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",db_user.getId());
        map.put("name", db_user.getUserName());
        map.put("sex", db_user.getUserSex());
        map.put("age", db_user.getUserAge());
        map.put("phone",db_user.getUserPhone());
        map.put("avatar",db_user.getUserAvatar());
        map.put("roles",db_user.getRoles());
        map.put("create_date",db_user.getCreateDate());
        map.put("update_date",db_user.getUpdateDate());
        return new R(map);
    }


    @GetMapping("/logout")
    public R logout(){
        return new R();
    }

    /**
     * 重置密码
     * @return
     */
    @PostMapping("/resetPwd")
    public R resetPwd(@RequestBody User user) {
        boolean b = userService.updateById(user);
        if (b) return new R();
        else return new R(20001, "密码重置失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody User user){
        boolean b = userService.updateById(user);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }

}
