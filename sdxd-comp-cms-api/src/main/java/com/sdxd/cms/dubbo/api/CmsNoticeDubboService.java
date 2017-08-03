package com.sdxd.cms.dubbo.api;

import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.response.CmsNoticeResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsNoticeDubboService {

	DubboResponse<CmsNoticeResponse> addCmsNotic(CmsNoticeRequest request);
	
	DubboResponse<CmsNoticeResponse> deleteCmsNotic(CmsNoticeRequest request);
	
	DubboResponse<CmsNoticeResponse> updataCmsNotic(CmsNoticeRequest request);
	
	DubboResponse<QueryCmsNoticeResponse> queryCmsNotic(CmsNoticeRequest request);

	DubboResponse<QueryCmsNoticeResponse> queryCmsNoticeStatus(CmsNoticeRequest request);
}
