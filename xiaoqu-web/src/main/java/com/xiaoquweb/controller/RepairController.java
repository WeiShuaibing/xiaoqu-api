package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.RepairService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repair")
@Api(value = "/repair", tags = {"物业维修相关接口"})
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping("/getById")
    public R getById(int id) {
        Repair byId = repairService.getById(id);
        return new R(byId);
    }

    @PostMapping("/add")
    public R add(@RequestBody Repair repair, @RequestHeader int XiaoQuToken) {
        repair.setUserId(XiaoQuToken);
        repair.setRepairStatus(1);
        boolean save = repairService.saveAndFenpei(repair);
        if (save) return new R();
        else return new R(20001, "服务异常，保存失败！");
    }

    @GetMapping("/getAllOfMy")
    public R getAllOfMy(@RequestHeader int XiaoQuToken){
        QueryWrapper<Repair> query = Wrappers.<Repair>query();
        query.eq("user_id", XiaoQuToken).orderByDesc("id");
        return new R(repairService.list(query));
    }

    /**
     * 增加评论信息
     */
    @PostMapping("/addEvaluate")
    public R addEvaluate(@RequestBody Repair repair) {
        boolean b = repairService.updateById(repair);
        if (b) {
            return new R();
        } else  {
            return new R(20001, "增加评论信息失败！");
        }
    }

}
