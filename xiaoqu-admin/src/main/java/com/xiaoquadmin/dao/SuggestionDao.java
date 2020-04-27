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


    @Select("select s.*,u.user_name, a.admin_name from suggestion s, `user` u, `admin` a " +
            "where s.user_id = u.id AND s.su_status = #{status} AND a.id=s.admin_id order by s.id desc LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow, int pageSize, int status);

    @Select("select s.*,u.user_name from suggestion s, `user` u " +
            "where s.user_id = u.id AND s.su_status = #{status} AND s.admin_id=#{admin_id} order by s.id desc LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPageOfEdit(int admin_id,int startRow, int pageSize, int status);

}
