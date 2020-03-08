package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.RepairDao;
import com.xiaoquadmin.dao.SuggestionDao;
import com.xiaoquadmin.service.RepairService;
import com.xiaoquadmin.service.SuggestionService;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl extends ServiceImpl<RepairDao, Repair> implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize, int status) {

        List<Map<String, Object>> page = repairDao.getPage((pageNum - 1) * pageSize, pageSize, status);
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(page,
                repairDao.selectCount(Wrappers.<Repair>query().eq("repair_status", status)));
        return mapMyPage;
    }
}
