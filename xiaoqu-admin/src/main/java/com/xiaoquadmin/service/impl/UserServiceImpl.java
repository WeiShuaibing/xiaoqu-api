package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.UserDao;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize) {
        List<Map<String, Object>> page = userDao.getPage((pageNum - 1) * pageSize, pageSize);
        MyPage<Map<String, Object>> userMyPage = new MyPage<Map<String,Object>>(page, userDao.selectCount(null));
        return userMyPage;
    }

    @Override
    public MyPage<Map<String, Object>> search(int pageNum, int pageSize, String matchStr) {
        List<Map<String, Object>> list = userDao.search((pageNum - 1) * pageSize, pageSize, "%" + matchStr + "%");
        MyPage<Map<String, Object>> mapMyPage = new MyPage<Map<String,Object>>(list, userDao.searchCount("%"+matchStr+"%"));
        return mapMyPage;
    }
}
