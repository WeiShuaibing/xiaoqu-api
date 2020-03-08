package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.pojo.R;

public interface AdminService extends IService<Admin> {

    public R verifyLogin(Admin admin);
}
