package com.sdxd.cms.service.impl;

import com.sdxd.cms.dao.CmsFeedDao;
import com.sdxd.cms.entity.CmsFeed;
import com.sdxd.cms.service.CmsFeedService;
import com.sdxd.framework.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.service.impl
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
@Service
public class CmsFeedServiceImpl extends BaseServiceImpl<CmsFeed> implements CmsFeedService {

    @Resource
    private CmsFeedDao cmsFeedDao;

    @Override
    public List<CmsFeed> searchPage(Integer startIndex, Integer pageSize, Integer isDisplay) {
        return cmsFeedDao.searchPage(startIndex, pageSize, isDisplay);
    }
}
