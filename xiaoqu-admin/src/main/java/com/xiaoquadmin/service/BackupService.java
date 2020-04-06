package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Backup;
import com.xiaoqucommon.pojo.R;

import java.util.List;
import java.util.Map;

public interface BackupService extends IService<Backup> {

    public List<Map<String, Object>> getPage(int pageNum, int pageSize);

}
