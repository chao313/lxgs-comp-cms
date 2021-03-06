package com.lxgs.cms.service;

import com.lxgs.cms.entity.CmsNotice;
import com.sdxd.framework.service.BaseService;

import java.util.Date;
import java.util.List;

public interface CmsNoticeSerivce extends BaseService<CmsNotice> {
    List<CmsNotice> getAllOnline(String merchantNo);
    List<CmsNotice> getAllNotice(String merchantNo);
}
