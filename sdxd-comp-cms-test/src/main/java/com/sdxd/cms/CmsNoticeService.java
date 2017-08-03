package com.sdxd.cms;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.CmsNoticeDubboService;
import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.response.CmsNoticeResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.framework.dubbo.DubboResponse;

@Service
public class CmsNoticeService {

	@Reference(version = "1.0.0")
	private CmsNoticeDubboService cmsNoticeDubboService;

	public DubboResponse<CmsNoticeResponse> addCmsNotic(CmsNoticeRequest request){
		return cmsNoticeDubboService.addCmsNotic(request);
	}

	public DubboResponse<CmsNoticeResponse> deleteCmsNotic(CmsNoticeRequest request){
		return cmsNoticeDubboService.deleteCmsNotic(request);
	}

	public DubboResponse<CmsNoticeResponse> updataCmsNotic(CmsNoticeRequest request){
		return cmsNoticeDubboService.updataCmsNotic(request);
	}

	public DubboResponse<QueryCmsNoticeResponse> queryCmsNotic(CmsNoticeRequest request){
		return cmsNoticeDubboService.queryCmsNotic(request);
	}

	public DubboResponse<QueryCmsNoticeResponse> queryCmsNoticeStatus(CmsNoticeRequest request) {
		return cmsNoticeDubboService.queryCmsNoticeStatus(request);
	}
}
