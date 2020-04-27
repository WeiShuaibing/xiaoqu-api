package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.entity.Topic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TopicDao extends BaseMapper<Topic> {

    @Select("select t.*, u.user_name, u.user_avatar from topic t, `user` u " +
            "where t.user_id = u.id order by t.topic_love desc limit #{pageSize}")
    public List<Map<String, Object>> getHotTopic(int pageSize);


    @Select("select t.*, u.user_name, u.user_avatar from topic t, `user` u " +
            "where t.user_id = u.id order by t.id desc limit #{startRow},#{pageSize}")
    public List<Map<String, Object>> getAllTopic(int startRow, int pageSize);

    @Select("select t.*, u.user_name, u.user_avatar from topic t, `user` u " +
            "where t.user_id = u.id order by t.id desc limit #{pageSize}")
    public List<Map<String, Object>> getNewTopic(int pageSize);


    @Select("select t.*, u.user_name, u.user_avatar from topic t, `user` u " +
            "where t.user_id = u.id AND t.topic_text like #{matchStr} order by t.topic_love desc")
    public List<Map<String, Object>> search(String matchStr);
}
