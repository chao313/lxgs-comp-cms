package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.CmsShareDubboService;
import com.sdxd.cms.dubbo.api.request.CmsShareRequest;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.framework.dubbo.DubboResponse;

import org.springframework.stereotype.Service;

@Service
public class CmsShareService {
	@Reference(version = "1.0.0")
	private CmsShareDubboService cmsShareDubboService;
	
	public DubboResponse<CmsShareResponse> findById(CmsShareRequest request){
		return cmsShareDubboService.findById(request);
	}

}
