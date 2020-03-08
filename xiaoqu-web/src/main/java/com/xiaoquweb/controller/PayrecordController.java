package com.xiaoquweb.controller;

import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.PayorderService;
import com.xiaoquweb.service.PayrecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payrecord")
@Api(value = "/payrecord", tags = {"缴费记录相关接口"})
public class PayrecordController {

    @Autowired
    private PayrecordService payrecordService;


    @GetMapping("/setNewRecord")
    public R setNewRecord(int id, @RequestHeader int YQYJToken){
        Payrecord record = new Payrecord();
        record.setUserId(YQYJToken);
        record.setPayorderId(id);
        record.setPayorderStatus(1);
        boolean save = payrecordService.save(record);
        if (save) return new R();
        else return new R(20001, "服务异常，缴费失败");
    }

    /**
     * 获取我的缴费记录
     */
    @GetMapping("/getMyRecord")
    public R getMyRecord(@RequestHeader int YQYJToken){
        List<Map<String, Object>> allHavedPay = payrecordService.getAllHavedPay(YQYJToken);
        return new R(allHavedPay);
    }

}
