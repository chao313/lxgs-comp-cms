package com.sdxd.cms.test;

import javax.annotation.Resource;

import com.sdxd.cms.CmsFeedService;
import com.sdxd.cms.dubbo.api.pojo.CmsFeedVo;
import com.sdxd.cms.dubbo.api.request.*;
import com.sdxd.cms.dubbo.api.response.*;
import com.sdxd.framework.dubbo.PageRequest;
import org.junit.Test;

import com.sdxd.cms.CmsBannerService;
import com.sdxd.cms.CmsNoticeService;
import com.sdxd.cms.CmsShareService;
import com.sdxd.cms.dubbo.api.enums.CmsBannerType;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;

import java.util.ArrayList;
import java.util.List;


public class ServiceTest extends BaseTest{

	@Resource
	private CmsBannerService cmsBannerService;
	
	@Resource
	private CmsNoticeService cmsNoticeService;

    @Resource
    private CmsShareService cmsShareService;

    @Resource
	private CmsFeedService cmsFeedService;

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
//		request.setLink("http://www.baiddu.com");
		DubboResponse<QueryCmsNoticeResponse> rt =	cmsNoticeService.queryCmsNotic(request);
		System.out.println("");
	}

	@Test
	public void testFindShare() {
		CmsShareRequest request = new CmsShareRequest();
		request.setSystemId("");
		request.setRequestId("");
		request.setId("t12345");
        DubboResponse<CmsShareResponse> response = cmsShareService.findById(request);
        response.getData();
//		cmsShareDubboService.findById(request);
	}

	@Test
	public void test_searchCmsFeedList(){
		PageRequest request = new PageRequest();
		request.setSystemId("test");
		request.setRequestId("test");
		request.setCurrentPage(1);
		request.setPageSize(10);

		DubboResponse<CmsFeedResponse> response = cmsFeedService.searchCmsFeedList(request);
	}

	@Test
	public void test_queryCmsFeed(){
		CmsFeedRequest request = new CmsFeedRequest();
		request.setSystemId("test");
		request.setRequestId("test");
		request.setId("201708181814520000000001");

		DubboResponse<CmsFeedResponse> response = cmsFeedService.queryCmsFeed(request);
	}

	@Test
	public void test_saveCmsFeed(){
		CmsFeedRequest request = new CmsFeedRequest();
		request.setSystemId("test");
		request.setRequestId("test");
		request.setCmsFeedVo(buildFeed());

		DubboResponse<CmsFeedResponse> response = cmsFeedService.saveCmsFeed(request);

	}

	@Test
	public void test_deleteCmsFeed(){
		CmsFeedRequest request = new CmsFeedRequest();
		request.setSystemId("test");
		request.setRequestId("test");

		request.setId("201708181814520000000001");
		DubboResponse<CmsFeedResponse> response = cmsFeedService.deleteCmsFeed(request);
	}

	private CmsFeedVo buildFeed(){
		CmsFeedVo feed = new CmsFeedVo();
		feed.setId("201708181814520000000001");
		feed.setTitle("盛大小贷");
		feed.setTag("热门");
		feed.setDisplay(1);
		List<String> imgList = new ArrayList<>();
		imgList.add("http://sdxd-oss-public.oss-cn-hzfinance.aliyuncs.com/2017081815382886548_H5-%E5%BE%AE%E4%BF%A1%E5%AF%BC%E6%B5%81-1.png");
		imgList.add("http://sdxd-oss-public.oss-cn-hzfinance.aliyuncs.com/2017081815382886548_H5-%E5%BE%AE%E4%BF%A1%E5%AF%BC%E6%B5%81-1.png");
		imgList.add("http://sdxd-oss-public.oss-cn-hzfinance.aliyuncs.com/2017081815382886548_H5-%E5%BE%AE%E4%BF%A1%E5%AF%BC%E6%B5%81-1.png");
		feed.setImgList(imgList);
		feed.setFeedUrl("www.baidu.com");
		feed.setFrom("盛大小贷");;
		feed.setComment(0);
		return feed;
	}
}
