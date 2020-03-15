package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Comment;
import com.xiaoqucommon.entity.Topic;
import com.xiaoqucommon.pojo.R;

public interface CommentService extends IService<Comment> {

    public R getPageComment(int pageNum, int pageSize,  int topicId);

    public int getSumOfLove(int topic_id);

}
