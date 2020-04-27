package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.entity.Suggestion;

public interface SuggestionService extends IService<Suggestion> {

    /**
     * 将用户的投诉建议保存到数据库中并分配空闲的管理员
     * @param suggestion
     * @return
     */
    public boolean saveAndFenpei(Suggestion suggestion);

}
