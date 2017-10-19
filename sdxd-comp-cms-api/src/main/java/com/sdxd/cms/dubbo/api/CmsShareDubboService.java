package com.sdxd.cms.dubbo.api;

import com.sdxd.cms.dubbo.api.request.CmsShareRequest;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsShareDubboService {

	DubboResponse<CmsShareResponse> findById(CmsShareRequest request);

}
