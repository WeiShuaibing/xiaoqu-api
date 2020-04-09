package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoquadmin.service.*;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private SuggestionService suggestionService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private PayorderService payorderService;

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

    @GetMapping("/getSuggestionStatus")
    public R getSuggestionStatus() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();

        // 发起投诉
        int su_count_1 = suggestionService.count(Wrappers.<Suggestion>query().eq("su_status", 1));
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("value", su_count_1);
        map1.put("name", "发起投诉");
        list.add(map1);
        // 已收到
        int su_count_2 = suggestionService.count(Wrappers.<Suggestion>query().eq("su_status", 2));
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("value", su_count_2);
        map2.put("name", "已收到");
        list.add(map2);
        // 已处理
        int su_count_3 = suggestionService.count(Wrappers.<Suggestion>query().eq("su_status", 3));
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("value", su_count_3);
        map3.put("name", "已处理");
        list.add(map3);
        return new R(list);
    }

    @GetMapping("/getRepairStatus")
    public R getRepairStatus() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();

        // 发起维修
        int su_count_1 = repairService.count(Wrappers.<Repair>query().eq("repair_status", 1));
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("value", su_count_1);
        map1.put("name", "发起维修");
        list.add(map1);
        // 已收到
        int su_count_2 = repairService.count(Wrappers.<Repair>query().eq("repair_status", 2));
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("value", su_count_2);
        map2.put("name", "已收到");
        list.add(map2);
        // 已处理
        int su_count_3 = repairService.count(Wrappers.<Repair>query().eq("repair_status", 3));
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("value", su_count_3);
        map3.put("name", "维修完毕");
        list.add(map3);
        return new R(list);
    }

    @GetMapping("/getPayStatus")
    public R getPayStatus() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        // 物业费
        Float su_count_1 = payorderService.getThisMonthTotalmoney(1);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("value", su_count_1);
        map1.put("name", "物业费");
        list.add(map1);
        // 停车费
        Float su_count_2 = payorderService.getThisMonthTotalmoney(2);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("value", su_count_2);
        map2.put("name", "停车费");
        list.add(map2);
        // 水费
        Float su_count_3 = payorderService.getThisMonthTotalmoney(3);
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("value", su_count_3);
        map3.put("name", "水费");
        list.add(map3);

        // 电费
        Float su_count_4 = payorderService.getThisMonthTotalmoney(4);
        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("value", su_count_4);
        map4.put("name", "电费");
        list.add(map4);

        return new R(list);
    }
}
