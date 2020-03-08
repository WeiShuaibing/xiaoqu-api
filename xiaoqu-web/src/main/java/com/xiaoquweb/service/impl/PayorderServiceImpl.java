package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;
import com.xiaoquweb.dao.PayorederDao;
import com.xiaoquweb.dao.PayrecordDao;
import com.xiaoquweb.service.PayorderService;
import com.xiaoquweb.service.PayrecordService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayorderServiceImpl extends ServiceImpl<PayorederDao, Payorder> implements PayorderService {

    @Autowired
    private PayorederDao orederDao;
    @Autowired
    private PayrecordDao recordDao;

    @Override
    public List<Payorder> getAllINotPay(int YQYJToken) {

        QueryWrapper<Payrecord> query = Wrappers.<Payrecord>query();
        query.eq("user_id", YQYJToken);
        List<Payrecord> payrecords = recordDao.selectList(query);
        System.out.println(payrecords);
        ArrayList<Integer> have_pay_order = new ArrayList<>();
        for (Payrecord payrecord : payrecords) {
            have_pay_order.add(payrecord.getPayorderId());
        }

        QueryWrapper<Payorder> queryOfOrder = Wrappers.<Payorder>query();
        queryOfOrder.eq("user_id", YQYJToken);
        if (have_pay_order.size() == 0) {
            return orederDao.selectList(queryOfOrder);
        } else {
            queryOfOrder.notIn("id", have_pay_order);
            List<Payorder> payorders = orederDao.selectList(queryOfOrder);
            return payorders;
        }
    }
}
