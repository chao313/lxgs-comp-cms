package com.sdxd.cms.dao;

import com.sdxd.cms.entity.CmsNotice;
import com.sdxd.framework.dao.BaseDao;

import java.util.Date;
import java.util.List;

public interface CmsNoticeDao extends BaseDao<CmsNotice> {
    List<CmsNotice> getAllOnline(Date onlineTime);
    List<CmsNotice> getAllNotice(Date offlineTime);
}
