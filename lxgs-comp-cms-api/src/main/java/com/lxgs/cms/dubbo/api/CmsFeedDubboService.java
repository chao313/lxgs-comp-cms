package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.request.CmsFeedPageRequest;
import com.lxgs.cms.dubbo.api.request.CmsFeedRequest;
import com.lxgs.cms.dubbo.api.response.CmsFeedResponse;
import com.sdxd.framework.dubbo.DubboResponse;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.lxgs.cms.dubbo.api
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
public interface CmsFeedDubboService {

    /**
     * 查询Feed素材列表
     * @param request
     * @return
     */
    DubboResponse<CmsFeedResponse> searchCmsFeedList(CmsFeedPageRequest request);

    /**
     * 查询Feed素材明细
     * @param request
     * @return
     */
    DubboResponse<CmsFeedResponse> queryCmsFeed(CmsFeedRequest request);

    /**
     * 更新Feed素材
     * @param request
     * @return
     */
    DubboResponse<CmsFeedResponse> saveCmsFeed(CmsFeedRequest request);

    /**
     * 删除Feed素材
     * @param request
     * @return
     */
    DubboResponse<CmsFeedResponse> deleteCmsFeed(CmsFeedRequest request);
}
