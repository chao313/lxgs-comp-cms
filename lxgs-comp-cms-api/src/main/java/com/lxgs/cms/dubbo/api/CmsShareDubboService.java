package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.request.CmsShareModelRequest;
import com.lxgs.cms.dubbo.api.request.CmsShareRequest;
import com.lxgs.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsShareDubboService {

	DubboResponse<CmsShareResponse> findById(CmsShareRequest request);

	DubboResponse<CmsShareResponse> getCmsShare(CmsShareModelRequest request);

}
