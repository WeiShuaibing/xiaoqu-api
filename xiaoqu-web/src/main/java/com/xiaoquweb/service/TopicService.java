package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.entity.Topic;
import com.xiaoqucommon.pojo.MyPage;

import java.util.List;
import java.util.Map;

public interface TopicService extends IService<Topic> {


    public List<Map<String, Object>> getHotTopic(int pageSize);

    public List<Map<String, Object>> getNewTopic(int pageSize);

    public MyPage getAllTopic(int pageNum, int pageSize);

    public List<Map<String, Object>> search(String matchStr);

}
