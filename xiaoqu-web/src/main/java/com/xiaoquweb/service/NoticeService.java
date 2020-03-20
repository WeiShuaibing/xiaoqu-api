package com.xiaoquweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;

import java.util.List;

public interface NoticeService extends IService<Notice> {

    public List<Notice> testGetAllNoticeInService();

}
