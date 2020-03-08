package com.xiaoquadmin.controller;

import com.xiaoquadmin.service.RepairService;
import com.xiaoquadmin.service.SuggestionService;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/repair")
@Api(value = "/repair", tags = {"物业维修相关接口"})
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize, int status) {
        MyPage<Map<String, Object>> page = repairService.getPage(pageNum, pageSize, status);
        return new R(page);

    }

    @GetMapping("/getById")
    public R getById(int id){
        Repair byId = repairService.getById(id);
        return new R(byId);
    }

    @GetMapping("/delete")
    public R delete(int id){
        boolean b = repairService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }


    @GetMapping("/search")
    public R search(int pageNum, int pageSize, String matchStr){
       return new R();
    }

    @GetMapping("/updateStatus")
    public R updateStatus(int id, int status) {
        Repair repair = new Repair();
        repair.setId(id);
        repair.setRepairStatus(status);
        boolean b = repairService.updateById(repair);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }


}
