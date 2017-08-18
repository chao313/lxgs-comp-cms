package com.sdxd.cms.dubbo.api.request;

import com.sdxd.cms.dubbo.api.pojo.CmsFeedVo;
import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dubbo.api.request.zhuge
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
public class CmsFeedRequest extends BaseRequest {
    private String id;
    private CmsFeedVo cmsFeedVo;
}
