package com.lxgs.cms.service.impl;
import com.lxgs.cms.dao.CmsNoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxgs.cms.entity.CmsNotice;
import com.lxgs.cms.service.CmsNoticeSerivce;
import com.sdxd.framework.service.impl.BaseServiceImpl;

import java.util.Date;
import java.util.List;

@Service
public class CmsNoticeSerivceImpl extends BaseServiceImpl<CmsNotice> implements CmsNoticeSerivce {

    @Autowired
    private CmsNoticeDao cmsNoticeDao;


    @Override
    public List<CmsNotice> getAllOnline(String merchantNo) {
        return cmsNoticeDao.getAllOnline(merchantNo);
    }

    @Override
    public List<CmsNotice> getAllNotice(String merchantNo) {
        return cmsNoticeDao.getAllNotice(merchantNo);
    }

}
