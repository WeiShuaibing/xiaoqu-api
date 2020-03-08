package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RepairDao extends BaseMapper<Repair> {


    @Select("select r.*,u.user_name from repair r, `user` u " +
            "where r.user_id = u.id AND r.repair_status = #{status} order by r.id desc LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow, int pageSize, int status);

}
