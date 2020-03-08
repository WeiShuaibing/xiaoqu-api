package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;

public interface UserService extends IService<User> {
    public R verifyLogin(User user);
}
