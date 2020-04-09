package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.PayorederDao;
import com.xiaoquadmin.dao.PayrecordDao;
import com.xiaoquadmin.dao.UserDao;
import com.xiaoquadmin.service.PayorderService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PayorderServiceImpl extends ServiceImpl<PayorederDao, Payorder> implements PayorderService {

    @Autowired
    private PayorederDao payorederDao;
    @Autowired
    private PayrecordDao recordDao;

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize, int type) {
        List<Map<String, Object>> list = payorederDao.getPage((pageNum - 1) * pageSize, pageSize, type);

        list.forEach(map -> {
            System.out.println("map:" + map);
            Payrecord payrecord = recordDao.selectOne(Wrappers.<Payrecord>query().eq("payorder_id", map.get("id")));
            if (payrecord != null) {
                map.put("payrecord_status", payrecord.getPayorderStatus());
            } else {
                map.put("payrecord_status", 2);
            }
        });

        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(list, payorederDao.getPageCount(type));
        return mapMyPage;
    }

    @Override
    public Float getThisMonthTotalmoney(int pay_type) {
        return payorederDao.getThisMonthTotalmoney(pay_type);
    }

}
