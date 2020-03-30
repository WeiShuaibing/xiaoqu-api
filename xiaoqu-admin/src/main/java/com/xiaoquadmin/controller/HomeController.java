package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.CarService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private CarService carService;

    @GetMapping("/getBaseData")
    public R getBaseData(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("adminCount", adminService.count());
        map.put("userCount", userService.count());
        map.put("buildingCount", buildingService.getBuildingCount());
        map.put("carCount", carService.count());
        map.put("activeUserData", userService.selectUserActiveNum(7));

        return new R(map);

    }

}
