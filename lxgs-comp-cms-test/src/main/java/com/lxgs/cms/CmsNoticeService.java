package com.lxgs.cms;

import com.lxgs.cms.dubbo.api.request.CmstomNoticeRequest;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lxgs.cms.dubbo.api.CmsNoticeDubboService;
import com.lxgs.cms.dubbo.api.request.CmsNoticeRequest;
import com.lxgs.cms.dubbo.api.response.CmsNoticeResponse;
import com.lxgs.cms.dubbo.api.response.QueryCmsNoticeResponse;
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

	public DubboResponse<QueryCmsNoticeResponse> queryCmsNoticeStatus(CmstomNoticeRequest request) {
		return cmsNoticeDubboService.queryCmsNoticeStatus(request);
	}
}
