package com.sdxd.cms.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.sdxd.cms.CmsBannerService;
import com.sdxd.cms.CmsNoticeService;
import com.sdxd.cms.dubbo.api.enums.CmsBannerType;
import com.sdxd.cms.dubbo.api.request.CmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.request.DeleteCmsBannerRequest;
import com.sdxd.cms.dubbo.api.request.QueryCmsBannerRequest;
import com.sdxd.cms.dubbo.api.response.CmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.CmsNoticeResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsBannerResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;


public class ServiceTest extends BaseTest{

	@Resource
	private CmsBannerService cmsBannerService;
	
	@Resource
	private CmsNoticeService cmsNoticeService;
	
	@Test
	public void testAddCmsBanner(){
		CmsBannerRequest request = new CmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setImageCode("ewrwcde4343e");
		request.setImageLink("http://www.baidu.com");
		request.setImageOrder(4);
		request.setImageUrl("http://");
		request.setName("hello");
		request.setType(CmsBannerType.APP.toString());
		DubboResponse<CmsBannerResponse> rt = cmsBannerService.addCmsBanner(request);
		System.out.println(rt);
	}
	@Test
	public void testUpdataCmsBanner(){
		CmsBannerRequest request = new CmsBannerRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setImageCode("mmmmmwwww");
		request.setId("c766563e86d942538e60fb5deb6ce7f6");
		request.setImageLink("http://www.souhu.com");
		request.setImageOrder(2);
		request.setImageUrl("http://www.baiddu.com");
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
		DubboResponse<QueryCmsBannerResponse> rt = cmsBannerService.queryCmsBanner(request);
		System.out.println("");
	}
	
	@Test
	public void testAddCmsNotice(){
		CmsNoticeRequest request = new CmsNoticeRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setTitle("第三方的司法解释");
		request.setLink("http://www.baiddu.com");
		DubboResponse<CmsNoticeResponse> rt =	cmsNoticeService.addCmsNotic(request);
		System.out.println("");
	}
	
	@Test
	public void testQueryCmsNotice(){
		CmsNoticeRequest request  =new CmsNoticeRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		//request.setTitle("hahah哈哈");
		request.setLink("http://www.baiddu.com");
		DubboResponse<QueryCmsNoticeResponse> rt =	cmsNoticeService.queryCmsNotic(request);
		System.out.println("");
	}
}
