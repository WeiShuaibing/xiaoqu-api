package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.UserDao;
import com.xiaoquadmin.service.UserService;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    @Override
    public List<Integer> selectUserActiveNum(int days) {
        List<Map<String, Object>> maps = userDao.selectUserActiveNum(days);
        System.out.println(maps);
        HashMap<String, Integer> day_count = new HashMap<>();
        for (Map<String, Object> map : maps) {
            day_count.put(map.get("days").toString(),Integer.valueOf(map.get("count").toString()));
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ArrayList<Integer> active_num_list = new ArrayList<>();
        for (int i=days-1;i >= 0;i--) {
            String day = now.minus(i, ChronoUnit.DAYS).format(formatter);
            if (day_count.containsKey(day)){
                active_num_list.add(day_count.get(day));
            } else {
                active_num_list.add(0);
            }
        }

        return active_num_list;
    }
}
