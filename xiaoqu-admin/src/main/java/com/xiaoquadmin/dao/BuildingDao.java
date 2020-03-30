package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Building;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BuildingDao extends BaseMapper<Building> {

    @Select("SELECT COUNT(DISTINCT bu_name) FROM building")
    public int getBuildingCount();

}
