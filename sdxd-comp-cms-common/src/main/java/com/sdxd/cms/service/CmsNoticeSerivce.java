package com.sdxd.cms.service;

import com.sdxd.cms.entity.CmsNotice;
import com.sdxd.framework.service.BaseService;

import java.util.Date;
import java.util.List;

public interface CmsNoticeSerivce extends BaseService<CmsNotice> {
    List<CmsNotice> getAllOnline(Date onlineTime);
    List<CmsNotice> getAllOffline(Date offlineTime);
}
