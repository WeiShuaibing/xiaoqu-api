package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;

import java.util.List;
import java.util.Map;

public interface PayrecordService extends IService<Payrecord> {

    public List<Map<String, Object>> getAllHavedPay(int user_id);

}
