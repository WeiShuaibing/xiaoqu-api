package com.xiaoquweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.PayorderService;
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


    @GetMapping("/getAllOfINotPay")
    public R getAllINotPay(@RequestHeader int YQYJToken){
        List<Payorder> allINotPay = payorderService.getAllINotPay(YQYJToken);
        return new R(allINotPay);
    }

}
