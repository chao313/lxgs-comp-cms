package com.sdxd.cms.dubbo.api.request;

import com.sdxd.cms.dubbo.api.pojo.CmsShareVo;
import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CmsShareUpdateRequest extends BaseRequest{

    private String id;
    private CmsShareVo cmsShareVo;

}
