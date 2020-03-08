package com.xiaoquweb.controller;


import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
