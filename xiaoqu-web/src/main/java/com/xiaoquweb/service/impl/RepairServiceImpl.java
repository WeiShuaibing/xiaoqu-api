package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoquweb.dao.RepairDao;
import com.xiaoquweb.dao.SuggestionDao;
import com.xiaoquweb.service.RepairService;
import com.xiaoquweb.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl extends ServiceImpl<RepairDao, Repair> implements RepairService {

    @Autowired
    private RepairDao repairDao;
    /**
     * 保存并分配管理员id
     * @return
     */
    @Override
    public boolean saveAndFenpei(Repair repair) {
        List<Map<String, Object>> maps = repairDao.queryAdminRepairStatistics();
        int admin_id = 0;
        long min_admin_sug_total = 10000;
        for (Map<String, Object> map : maps) {
            if (min_admin_sug_total > Long.valueOf(map.get("total").toString())) {
                min_admin_sug_total = Long.valueOf(map.get("total").toString());
                admin_id = Integer.valueOf(map.get("admin_id").toString());
            }
        }
        repair.setAdminId(admin_id);
        boolean save = this.save(repair);
        return save;
    }

}
