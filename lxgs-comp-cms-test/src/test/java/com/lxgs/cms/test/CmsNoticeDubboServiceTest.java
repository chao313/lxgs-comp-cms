package com.lxgs.cms.test;

import com.lxgs.cms.CmsNoticeService;
import com.lxgs.cms.dubbo.api.CmsNoticeDubboService;
import com.lxgs.cms.dubbo.api.pojo.CmsNoticeVo;
import com.lxgs.cms.dubbo.api.request.CmsNoticeRequest;
import com.lxgs.cms.dubbo.api.request.CmstomNoticeRequest;
import com.lxgs.cms.dubbo.api.response.QueryCmsNoticeResponse;
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
        CmstomNoticeRequest cmsNoticeRequest = new CmstomNoticeRequest();
        cmsNoticeRequest.setStatus(true);
        cmsNoticeRequest.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<QueryCmsNoticeResponse> response = cmsNoticeService.queryCmsNoticeStatus(cmsNoticeRequest);
        List<CmsNoticeVo> list = response.getData().getList();
        System.out.println("noticeData:"+list.toString());
    }
}
