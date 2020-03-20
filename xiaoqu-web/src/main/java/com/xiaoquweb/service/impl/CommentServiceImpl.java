package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Comment;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.dao.CommentDao;
import com.xiaoquweb.dao.UserDao;
import com.xiaoquweb.service.CommentService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;
    @Override
    public R getPageComment(int pageNum, int pageSize, int topicId) {
        /**
         * 获取评论信息，构造评论信息结构
         * 1. 获取所有的父评论
         * 2. 根据父评论 获取子评论
         * 3. 循环递归获取所有的子评论信息
         */

        List<Map<String, Object>> parent_comments = commentDao.getPageComment((pageNum-1)*pageSize,pageSize, topicId);
        for (Map<String, Object> comment : parent_comments) {
            List<Map<String, Object>> allByParentId2 = getAllByParentId2(Integer.valueOf(comment.get("id").toString()));

            for (Map<String, Object> map : allByParentId2) {
                Comment select_comment = commentDao.selectOne(Wrappers.<Comment>query().eq("id", map.get("comment_parent_id")));
                User user = userDao.selectOne(Wrappers.<User>query().eq("id", select_comment.getUserId()));
                map.put("parent_user_name", user.getUserName());
                map.put("parent_user_id", user.getId());
            }

            comment.put("children",allByParentId2);
        }
        return new R(parent_comments);
    }

    public List<Map<String, Object>> getAllByParentId2(int parent_id){
        ArrayList<Map<String, Object>> children_comments = new ArrayList<>();
        List<Map<String, Object>> comments = commentDao.getCommentOfChildren(parent_id);
        if (comments.size() != 0) {
            children_comments.addAll(comments);
            for (Map<String, Object> co : comments) {
                List<Map<String, Object>> allByParentId2 = getAllByParentId2(Integer.valueOf(co.get("id").toString()));
                for (Map<String, Object> map : allByParentId2) {
                    Comment select_comment = commentDao.selectOne(Wrappers.<Comment>query().eq("id", map.get("comment_parent_id")));
                    User user = userDao.selectOne(Wrappers.<User>query().eq("id", select_comment.getUserId()));
                    map.put("parent_user_name", user.getUserName());
                    map.put("parent_user_id", user.getId());
                }

                children_comments.addAll(allByParentId2);
            }
        }
        return children_comments;
    }

    public int getSumOfLove(int topic_id){
        Integer sumOfLove = 0;
        try {
            sumOfLove = commentDao.getSumOfLove(topic_id);
        }catch (Exception e) {
            sumOfLove = 0;
        }
        return sumOfLove;
    }

}
