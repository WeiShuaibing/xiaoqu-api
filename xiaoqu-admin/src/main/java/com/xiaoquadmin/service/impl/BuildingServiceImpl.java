package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.AdminDao;
import com.xiaoquadmin.dao.BuildingDao;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.pojo.R;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingDao, Building> implements BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    /**
     * 获取格式化的信息
     * @return
     */
    @Override
    public List<Map<String, Object>> getHomeFormat() {
        QueryWrapper<Building> query = Wrappers.<Building>query();
        query.groupBy("bu_name").select("bu_name");
        List<Building> bu_names = buildingDao.selectList(query);

        ArrayList<Map<String, Object>> format_data = new ArrayList<>();

        for (Building bu : bu_names) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("label", bu.getBuName());
            map.put("value", bu.getBuName());
            List<Building> child_list = buildingDao.selectList(Wrappers.<Building>query().eq("bu_name", bu.getBuName()));
            ArrayList<Map<String, Object>> child_map= new ArrayList<>();
            for (Building building : child_list) {
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("label", building.getBuHome());
                map1.put("value", building.getId());
                child_map.add(map1);
            }
            map.put("children", child_map);
            format_data.add(map);
        }
        return format_data;
    }
}
