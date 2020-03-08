package com.xiaoquweb.controller;


import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building")
@Api(value = "/building", tags = {"用户相关接口"})
public class BuildingController {

    @Autowired
    private BuildingService buildingService;


    @GetMapping("/getById")
    public R getById(int id) {
        Building byId = buildingService.getById(id);
        return new R(byId);
    }


}
