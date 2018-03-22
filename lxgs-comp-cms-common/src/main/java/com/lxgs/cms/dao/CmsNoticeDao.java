package com.lxgs.cms.dao;

import com.lxgs.cms.entity.CmsNotice;
import com.sdxd.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CmsNoticeDao extends BaseDao<CmsNotice> {
    List<CmsNotice> getAllOnline(@Param("merchantNo") String merchantNo);
    List<CmsNotice> getAllNotice(@Param("merchantNo") String merchantNo);
}
