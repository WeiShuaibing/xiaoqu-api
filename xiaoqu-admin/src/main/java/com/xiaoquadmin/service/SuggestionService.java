package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;

import java.util.List;
import java.util.Map;

public interface SuggestionService extends IService<Suggestion> {

    public MyPage<Map<String, Object>> getPage(int pagNum, int pageSize, int status);

    public MyPage<Map<String, Object>> getPageOfEdit(int token,int pageNum, int pageSize, int status);

}
