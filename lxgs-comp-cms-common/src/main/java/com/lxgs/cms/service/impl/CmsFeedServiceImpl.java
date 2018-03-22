package com.lxgs.cms.service.impl;

import com.lxgs.cms.dao.CmsFeedDao;
import com.lxgs.cms.entity.CmsFeed;
import com.lxgs.cms.service.CmsFeedService;
import com.sdxd.framework.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.lxgs.cms.service.impl
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
    public List<CmsFeed> searchPage(List<Integer> templateList, Integer isDisplay, Integer startIndex, Integer pageSize) {
        return cmsFeedDao.searchPage(templateList, isDisplay, startIndex, pageSize);
    }
}
