package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.dao.UserDao;
import com.xiaoquweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public R verifyLogin(User user) {

        QueryWrapper<User> wrapper = Wrappers.<User>query();
        wrapper.eq("user_phone",user.getUserPhone());
        User db_user = userDao.selectOne(wrapper);
        R r = new R();
        if (db_user == null){
            r.setCode(20001);
            r.setMsg("无此账户");
        }else if (!db_user.getUserPassword().equals(user.getUserPassword())){
            r.setCode(20001);
            r.setMsg("密码错误");
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("token",db_user.getId());
            map.put("name", db_user.getUserName());
            map.put("sex", db_user.getUserSex());
            map.put("age", db_user.getUserAge());
            map.put("phone",db_user.getUserPhone());
            map.put("avatar",db_user.getUserAvatar());
            map.put("roles",db_user.getRoles());
            map.put("create_date",db_user.getCreateDate());
            map.put("update_date",db_user.getUpdateDate());
            r.setData(map);
            db_user.setUpdateDate(new Date());
            userDao.insert(db_user);
        }
        return r;

    }

}
