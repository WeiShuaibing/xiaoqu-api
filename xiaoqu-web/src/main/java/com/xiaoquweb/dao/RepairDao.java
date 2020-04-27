package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RepairDao extends BaseMapper<Repair> {
    /**
     * 查询统计每个物业人员有几个任务
     */
    @Select("SELECT admin_id,COUNT(*) total FROM `repair` GROUP BY admin_id")
    List<Map<String, Object>> queryAdminRepairStatistics();

}
