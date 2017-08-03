package com.sdxd.cms.test;

import com.sdxd.cms.CmsNoticeService;
import com.sdxd.cms.dubbo.api.CmsNoticeDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsNoticeVo;
import com.sdxd.cms.dubbo.api.request.CmsNoticeRequest;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by matteo on 2017/8/3.
 */
public class CmsNoticeDubboServiceTest extends BaseTest{


    @Resource
    private CmsNoticeService cmsNoticeService;

    @Test
    public void testOnline(){
        CmsNoticeRequest cmsNoticeRequest = new CmsNoticeRequest();
        cmsNoticeRequest.setStatus(true);
        cmsNoticeRequest.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<QueryCmsNoticeResponse> response = cmsNoticeService.queryCmsNoticeStatus(cmsNoticeRequest);
        List<CmsNoticeVo> list = response.getData().getList();
        System.out.println("noticeData:"+list.toString());
    }
}
