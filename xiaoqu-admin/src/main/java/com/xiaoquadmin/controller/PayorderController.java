package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.PayorderService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payorder")
@Api(value = "/payorder", tags = {"物业缴费相关接口"})
public class PayorderController {

    @Autowired
    private PayorderService payorderService;

    @PostMapping("/add")
    public R add(@RequestBody Payorder payorder){
        boolean save = payorderService.save(payorder);
        if (save) return new R();
        else return new R(20001, "保存失败！");
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize, int type) {
        return new R(payorderService.getPage(pageNum, pageSize, type));
    }

    @GetMapping("/delete")
    public R delete(int id) {
        boolean b = payorderService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody Payorder payorder){
        boolean b = payorderService.updateById(payorder);
        if (b) {
            return new R();
        }else {
            return new R(20001, "修改异常");
        }
    }

}
