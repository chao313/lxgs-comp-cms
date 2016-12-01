package com.sdxd.cms.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.sdxd.cms.CmsBannerService;
import com.sdxd.cms.dubbo.api.enums.CmsBannerType;
import com.sdxd.cms.dubbo.api.request.CmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.sdxd.cms.dubbo.api.response.CmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmdBannerResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;


public class ServiceTest extends BaseTest{

	@Resource
	private CmsBannerService cmsBannerService;
	@Test
	public void testAddCmsBanner(){
		CmsBannerRequest request = new CmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setImage_code("mmmmmwwww");
		request.setImage_link("http://www.baidu.com");
		request.setImage_order(1);
		request.setImage_url("http://");
		request.setName("中问");
		request.setType(CmsBannerType.APP.toString());
		DubboResponse<CmsBannerResponse> rt = cmsBannerService.addCmsBanner(request);
		System.out.println(rt);
	}
	@Test
	public void testUpdataCmsBanner(){
		CmsBannerRequest request = new CmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setImage_code("mmmmmwwww");
		request.setId("c766563e86d942538e60fb5deb6ce7f6");
		request.setImage_link("http://www.souhu.com");
		request.setImage_order(2);
		request.setImage_url("http://www.baiddu.com");
		request.setType(CmsBannerType.APP.toString());
		DubboResponse<CmsBannerResponse> rt = cmsBannerService.updataCmsBanner(request);
		System.out.println(rt);
	}
	
	@Test
	public void testDeleteCmsBanner(){
		DeleteCmsBannerRequest request = new DeleteCmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setId("c766563e86d942538e60fb5deb6ce7f6");
		DubboResponse<CmsBannerResponse> rt = cmsBannerService.deleteCmsBanner(request);
		
	}
	
	@Test
	public void testQueryCmsBanner(){
		QueryCmsBannerRequest request = new QueryCmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setType(CmsBannerType.APP.toString());
		DubboResponse<QueryCmdBannerResponse> rt = cmsBannerService.queryCmsBanner(request);
		System.out.println("");
	}
}
