package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Car;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoquweb.dao.CarDao;
import com.xiaoquweb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize) {
        List<Map<String, Object>> list = carDao.getPage((pageNum - 1) * pageSize, pageSize);
        QueryWrapper<Car> query = Wrappers.<Car>query();
        query.isNotNull("user_id");
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(list, carDao.selectCount(query));
        return mapMyPage;
    }


    @Override
    public MyPage<Map<String, Object>> getPageOfNoUser(int pageNum, int pageSize) {
        List<Map<String, Object>> list = carDao.getPageOfNoUser((pageNum - 1) * pageSize, pageSize);
        QueryWrapper<Car> query = Wrappers.<Car>query();
        query.isNull("user_id");
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(list, carDao.selectCount(query));
        return mapMyPage;
    }
}
