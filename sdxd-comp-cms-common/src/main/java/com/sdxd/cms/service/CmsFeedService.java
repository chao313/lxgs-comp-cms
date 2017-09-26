package com.sdxd.cms.service;

import com.sdxd.cms.entity.CmsFeed;
import com.sdxd.framework.service.BaseService;

import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.service
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
public interface CmsFeedService extends BaseService<CmsFeed> {

    List<CmsFeed> searchPage(List<Integer> templateList, Integer isDisplay, Integer startIndex, Integer pageSize);
}