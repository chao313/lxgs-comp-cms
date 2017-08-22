package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.CmsFeedDubboService;
import com.sdxd.cms.dubbo.api.request.CmsFeedPageRequest;
import com.sdxd.cms.dubbo.api.request.CmsFeedRequest;
import com.sdxd.cms.dubbo.api.response.CmsFeedResponse;
import com.sdxd.framework.dubbo.DubboResponse;
import org.springframework.stereotype.Service;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/18    wenzhou.xu              Created
 */
@Service
public class CmsFeedService {

    @Reference(version = "1.0.0")
    private CmsFeedDubboService cmsFeedDubboService;

    /**
     * 查询Feed素材列表
     * @param request
     * @return
     */
    public DubboResponse<CmsFeedResponse> searchCmsFeedList(CmsFeedPageRequest request){
        return cmsFeedDubboService.searchCmsFeedList(request);
    }

    /**
     * 查询Feed素材明细
     * @param request
     * @return
     */
    public DubboResponse<CmsFeedResponse> queryCmsFeed(CmsFeedRequest request){
        return cmsFeedDubboService.queryCmsFeed(request);
    }

    /**
     * 更新Feed素材
     * @param request
     * @return
     */
    public DubboResponse<CmsFeedResponse> saveCmsFeed(CmsFeedRequest request){
        return cmsFeedDubboService.saveCmsFeed(request);
    }

    /**
     * 删除Feed素材
     * @param request
     * @return
     */
    public DubboResponse<CmsFeedResponse> deleteCmsFeed(CmsFeedRequest request){
        return cmsFeedDubboService.deleteCmsFeed(request);
    }
}
