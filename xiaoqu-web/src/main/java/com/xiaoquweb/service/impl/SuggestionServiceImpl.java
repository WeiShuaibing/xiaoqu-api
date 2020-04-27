package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoquweb.dao.BuildingDao;
import com.xiaoquweb.dao.SuggestionDao;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SuggestionServiceImpl extends ServiceImpl<SuggestionDao, Suggestion> implements SuggestionService {


    @Autowired
    private SuggestionDao suggestionDao;

    /**
     * 保存并分配管理员id
     * @param suggestion
     * @return
     */
    @Override
    public boolean saveAndFenpei(Suggestion suggestion) {
        List<Map<String, Object>> maps = suggestionDao.queryAdminSuggestionStatistics();
        int admin_id = 0;
        long min_admin_sug_total = 10000;
        for (Map<String, Object> map : maps) {
            if (min_admin_sug_total > Long.valueOf(map.get("total").toString())) {
                min_admin_sug_total = Long.valueOf(map.get("total").toString());
                admin_id = Integer.valueOf(map.get("admin_id").toString());
            }
        }
        suggestion.setAdminId(admin_id);
        boolean save = this.save(suggestion);
        return save;
    }
}
