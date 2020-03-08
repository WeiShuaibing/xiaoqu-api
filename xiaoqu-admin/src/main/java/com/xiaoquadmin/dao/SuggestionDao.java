package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Suggestion;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SuggestionDao extends BaseMapper<Suggestion> {


    @Select("select s.*,u.user_name from suggestion s, `user` u " +
            "where s.user_id = u.id AND s.su_status = #{status} order by s.id desc LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow, int pageSize, int status);

}
