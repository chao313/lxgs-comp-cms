package com.sdxd.cms.service.impl;
import com.sdxd.cms.dao.CmsNoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdxd.cms.entity.CmsNotice;
import com.sdxd.cms.service.CmsNoticeSerivce;
import com.sdxd.framework.service.impl.BaseServiceImpl;

import java.util.Date;
import java.util.List;

@Service
public class CmsNoticeSerivceImpl extends BaseServiceImpl<CmsNotice> implements CmsNoticeSerivce {

    @Autowired
    private CmsNoticeDao cmsNoticeDao;


    @Override
    public List<CmsNotice> getAllOnline(Date onlineTime) {
        return cmsNoticeDao.getAllOnline(onlineTime);
    }

    @Override
    public List<CmsNotice> getAllOffline(Date offlineTime) {
        return cmsNoticeDao.getAllOffline(offlineTime);
    }

}
