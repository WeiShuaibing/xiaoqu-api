package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.PayorederDao;
import com.xiaoquadmin.dao.UserDao;
import com.xiaoquadmin.service.PayorderService;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.Payorder;
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

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize, int type) {
        List<Map<String, Object>> list = payorederDao.getPage((pageNum - 1) * pageSize, pageSize, type);
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(list, payorederDao.getPageCount(type));
        return mapMyPage;
    }
}
