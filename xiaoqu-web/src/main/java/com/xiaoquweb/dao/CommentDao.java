package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Comment;
import com.xiaoqucommon.entity.Topic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentDao extends BaseMapper<Comment> {


    @Select("SELECT c.*, u.user_name, u.user_avatar FROM `comment` c, `user` u " +
            "WHERE c.user_id = u.id AND c.comment_parent_id = 0 AND c.topic_id=#{topicId} ORDER BY c.comment_love DESC LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPageComment(int startRow, int pageSize, int topicId);

    @Select("SELECT c.*, u.user_name, u.user_avatar FROM `comment` c, `user` u " +
            "WHERE c.user_id = u.id AND c.comment_parent_id = #{parent_id} ORDER BY c.id DESC")
    public List<Map<String, Object>> getCommentOfChildren(int parent_id);


    @Select("SELECT SUM(comment_love) FROM `comment` WHERE topic_id = #{topic_id} ")
    public int getSumOfLove(int topic_id);

}
