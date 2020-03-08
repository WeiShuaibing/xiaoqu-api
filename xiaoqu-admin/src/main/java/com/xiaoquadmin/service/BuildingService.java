package com.xiaoquadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.User;

import java.util.List;
import java.util.Map;

public interface BuildingService extends IService<Building> {
    public List<Map<String, Object>> getHomeFormat();
}
