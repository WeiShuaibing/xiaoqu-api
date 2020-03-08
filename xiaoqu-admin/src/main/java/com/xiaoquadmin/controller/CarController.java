package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoquadmin.service.CarService;
import com.xiaoquadmin.service.RepairService;
import com.xiaoqucommon.entity.Car;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/car")
@Api(value = "/car", tags = {"停车位管理相关接口"})
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public R add(@RequestBody Car car) {
        boolean save = carService.save(car);
        if (save) return new R();
        else return new R(20001, "服务异常，保存失败！");
    }

    @GetMapping("/getById")
    public R getById(int id){
        Car byId = carService.getById(id);
        return new R(byId);
    }

    @GetMapping("/delete")
    public R delete(int id) {
        boolean b = carService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody Car car){
        boolean b = carService.updateById(car);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }


    @GetMapping("/getPage")
    public R getPage(int pageNum ,int pageSize, int carStatus) {

        if (carStatus == 1) {
            MyPage<Map<String, Object>> page = carService.getPage(pageNum, pageSize);
            return new R(page);
        } else {
            MyPage<Map<String, Object>> pageOfNoUser = carService.getPageOfNoUser(pageNum, pageSize);
            return new R(pageOfNoUser);
        }
    }
}
