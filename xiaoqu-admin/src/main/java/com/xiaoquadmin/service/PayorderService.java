package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;

import java.util.List;
import java.util.Map;

public interface PayorderService extends IService<Payorder> {


    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize, int type);

    public Float getThisMonthTotalmoney(int pay_type);

}
