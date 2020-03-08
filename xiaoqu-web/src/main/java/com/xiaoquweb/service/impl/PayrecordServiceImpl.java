package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;
import com.xiaoquweb.dao.PayorederDao;
import com.xiaoquweb.dao.PayrecordDao;
import com.xiaoquweb.service.PayorderService;
import com.xiaoquweb.service.PayrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayrecordServiceImpl extends ServiceImpl<PayrecordDao, Payrecord> implements PayrecordService {

    @Autowired
    private PayrecordDao payrecordDao;

    @Override
    public List<Map<String, Object>> getAllHavedPay(int user_id) {
        return payrecordDao.getAllHavedPay(user_id);
    }
}
