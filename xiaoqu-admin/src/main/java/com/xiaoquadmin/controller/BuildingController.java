package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/building")
@Api(value = "/building", tags = {"楼房相关接口"})
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<Building> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Building> query = Wrappers.<Building>query();
        query.orderByDesc("id");
        Page<Building> page1 = buildingService.page(page, query);
        return new R(page1);
    }

    @GetMapping("/getAll")
    public R getAll(){
        List<Building> list = buildingService.list();
        return new R(list);
    }

    @PostMapping("/add")
    public R add(@RequestBody Building building) {
        boolean b = buildingService.save(building);
        if (b) return new R();
        else return new R(20001, "添加失败！");
    }

    @GetMapping("/getById")
    public R getById(int id){
        Building byId = buildingService.getById(id);
        return new R(byId);
    }

    @GetMapping("/delete")
    public R delete(int id){
        boolean b = buildingService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody Building building){
        boolean b = buildingService.updateById(building);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }

    @GetMapping("/selectAllBuName")
    public R selectAllBuName() {
        QueryWrapper<Building> query = Wrappers.<Building>query();
        query.select("bu_name").groupBy("bu_name");
        List<Building> list = buildingService.list(query);
        return new R(list);
    }

    @GetMapping("/search")
    public R search(int pageNum, int pageSize, String matchStr){
        QueryWrapper<Building> query = Wrappers.<Building>query();
        query.like("bu_name", matchStr).or().like("bu_home", matchStr).or().like("bu_remark", matchStr);
        Page<Building> buildingPage = new Page<>(pageNum, pageSize);
        Page<Building> page = buildingService.page(buildingPage, query);
        return new R(page);
    }

    /**
     * 获取格式化的楼房信息
     * @return
     */
    @GetMapping("/getHomeFormat")
    public R getHomeFormat(){
        List<Map<String, Object>> homeFormat = buildingService.getHomeFormat();
        return new R(homeFormat);
    }

}
