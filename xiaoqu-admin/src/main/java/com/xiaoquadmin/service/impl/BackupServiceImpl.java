package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.AdminDao;
import com.xiaoquadmin.dao.BackupDao;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.BackupService;
import com.xiaoquadmin.service.LogService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Backup;
import com.xiaoqucommon.entity.Log;
import com.xiaoqucommon.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BackupServiceImpl extends ServiceImpl<BackupDao, Backup> implements BackupService {

    @Autowired
    private BackupDao backupDao;

    public List<Map<String, Object>> getPage(int pageNum, int pageSize){
        List<Map<String, Object>> list = backupDao.getPage((pageNum - 1) * pageSize, pageSize);
        return list;
    }

}
