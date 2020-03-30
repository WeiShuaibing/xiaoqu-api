package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize);


    MyPage<Map<String, Object>> search(int pageNum, int pageSize, String matchStr);


    public List<Integer> selectUserActiveNum(int days);
}
