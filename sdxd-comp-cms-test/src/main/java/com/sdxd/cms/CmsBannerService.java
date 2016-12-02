package com.sdxd.cms;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.CmsBannerDubboService;
import com.sdxd.cms.dubbo.api.request.CmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.sdxd.cms.dubbo.api.response.CmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsBannerResponse;
import com.sdxd.framework.dubbo.DubboResponse;

@Service
public class CmsBannerService {
	@Reference(version = "1.0.0")
	private CmsBannerDubboService cmsBannerDubberService;
	
	public DubboResponse<CmsBannerResponse> addCmsBanner(CmsBannerRequest request){
		return cmsBannerDubberService.addCmsBanner(request);
	}
	/*
	 * 更新轮播图
	 */
	public DubboResponse<CmsBannerResponse> updataCmsBanner(CmsBannerRequest request){
		return cmsBannerDubberService.updataCmsBanner(request);
	}
	/*
	 * 删除轮播图
	 */
	public DubboResponse<CmsBannerResponse> deleteCmsBanner(DeleteCmsBannerRequest request){
		return cmsBannerDubberService.deleteCmsBanner(request);
	}
	/*
	 * 查询轮播图
	 */
	public DubboResponse<QueryCmsBannerResponse> queryCmsBanner(QueryCmsBannerRequest request){
		return cmsBannerDubberService.queryCmsBanner(request);
	}
}
