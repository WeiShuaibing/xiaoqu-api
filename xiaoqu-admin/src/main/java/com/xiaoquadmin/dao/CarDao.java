package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Car;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CarDao extends BaseMapper<Car> {

    @Select("select c.*, u.user_name, u.user_phone from `user` u, car c where " +
            "c.user_id = u.id order by c.id desc LiMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow , int pageSize);

    // 查询未分配的停车位
    @Select("select c.* from car c where " +
            "c.user_id is null order by c.id desc LiMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPageOfNoUser(int startRow , int pageSize);

}
