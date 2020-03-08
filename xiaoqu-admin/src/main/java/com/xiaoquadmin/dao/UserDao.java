package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseMapper<User> {

    @Select("select u.*,b.id bu_id, b.bu_name, b.bu_home from `user` u, building b where u.bu_id=b.id order by u.id desc limit #{startRow},#{pageSize}")
    List<Map<String, Object>> getPage(int startRow, int pageSize);

    @Select("select u.*,b.id bu_id, b.bu_name, b.bu_home from `user` u, building b " +
            "where u.bu_id=b.id AND u.user_name like #{matchStr} order by u.id desc limit #{startRow},#{pageSize}")
    List<Map<String, Object>> search(int startRow, int pageSize, String matchStr);

    @Select("select count(*) from `user` u, building b " +
            "where u.bu_id=b.id AND u.user_name like #{matchStr}")
    int searchCount(String matchStr);

}
