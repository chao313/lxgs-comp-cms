package com.sdxd.cms.dubbo.api.response;

import com.sdxd.cms.dubbo.api.pojo.CmsFeedVo;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseResponse;
import lombok.Data;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dubbo.api.response
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
@Data
public class CmsFeedResponse extends BaseResponse {
    private Boolean success;
    private CmsFeedVo cmsFeedVo;
    private PaginationSupport<CmsFeedVo> page;
}
