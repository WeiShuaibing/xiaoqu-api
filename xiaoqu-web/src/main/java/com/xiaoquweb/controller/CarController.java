package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoqucommon.entity.Car;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.CarService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@Api(value = "/car", tags = {"车位相关接口"})
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getByUserId")
    public R getByUserId(int user_id) {
        QueryWrapper<Car> query = Wrappers.<Car>query();
        query.eq("user_id", user_id);
        return new R(carService.getOne(query));
    }


    @GetMapping("/test")
    public R test(){
        return new R();
    }

}
