package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Car;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.pojo.MyPage;

import java.util.List;
import java.util.Map;

public interface CarService extends IService<Car> {

    public MyPage<Map<String, Object>> getPage(int pageNum , int pageSize);
    public MyPage<Map<String, Object>> getPageOfNoUser(int pageNum , int pageSize);

}
