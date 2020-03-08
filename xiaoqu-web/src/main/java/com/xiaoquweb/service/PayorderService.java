package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Payorder;

import java.util.List;

public interface PayorderService extends IService<Payorder> {

    public List<Payorder> getAllINotPay(int YQYJToken);

}
