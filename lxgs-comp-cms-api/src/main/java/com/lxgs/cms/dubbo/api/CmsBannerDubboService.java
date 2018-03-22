package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.request.CmsBannerRequest;
import com.lxgs.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.lxgs.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.lxgs.cms.dubbo.api.response.CmsBannerResponse;
import com.lxgs.cms.dubbo.api.response.QueryCmsBannerResponse;
import com.sdxd.framework.dubbo.DubboResponse;

public interface CmsBannerDubboService {

	/*
	 * 添加轮播图
	 */
	DubboResponse<CmsBannerResponse> addCmsBanner(CmsBannerRequest request);
	/*
	 * 更新轮播图
	 */
	DubboResponse<CmsBannerResponse> updataCmsBanner(CmsBannerRequest request);
	/*
	 * 删除轮播图
	 */
	DubboResponse<CmsBannerResponse> deleteCmsBanner(DeleteCmsBannerRequest request);
	/*
	 * 查询轮播图
	 */
	DubboResponse<QueryCmsBannerResponse> queryCmsBanner(QueryCmsBannerRequest request);
	
	
	
}
