package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;

import java.util.Map;

public interface RepairService extends IService<Repair> {

    public MyPage<Map<String, Object>> getPage(int pagNum, int pageSize, int status);


    public MyPage<Map<String, Object>> getPageOfEdit(int token,int pageNum, int pageSize, int status);
}
