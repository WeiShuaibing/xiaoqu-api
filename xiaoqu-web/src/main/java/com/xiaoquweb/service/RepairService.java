package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;

public interface RepairService extends IService<Repair> {

    /**
     * 将用户的报修存到数据库中并分配空闲的管理员
     * @param repair
     * @return
     */
    public boolean saveAndFenpei(Repair repair);

}
