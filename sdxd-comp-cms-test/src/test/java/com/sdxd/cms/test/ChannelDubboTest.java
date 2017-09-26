package com.sdxd.cms.test;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.sdxd.cms.OtherChannelService;
import com.sdxd.cms.dubbo.api.CmsNoticeDubboService;
import com.sdxd.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.sdxd.cms.dubbo.api.request.*;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.cms.dubbo.api.response.QueryCmsNoticeResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import org.hyperic.sigar.cmd.Du;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
public class ChannelDubboTest extends BaseTest {

    @Resource
    private OtherChannelService otherChannelService;

    @Test
    public void create() {
        OtherChannelDetailRequest request = new OtherChannelDetailRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setChannelUrl("http://wwww.baidu.com");
        request.setChannelName("芝麻花呗222222");
        request.setChannelIndex(2);
        request.setChannelLogo("http://wwww/baodu.com.cn");
        request.setChannelSlogn("方便22");
        request.setChannelType("h5");
        request.setChannelListLogo("logo");
        request.setChannelShowWay(0);
        DubboResponse<OtherChannelDetailResponse> c = otherChannelService.save(request);
        System.out.println(c);
    }

    @Test
    public void update() {
        UpdateOtherChannelDetailRequest request = new UpdateOtherChannelDetailRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setChannelUrl("http://wwww.baidu.com");
        request.setChannelName("测试002");
        request.setChannelIndex(2);
        request.setDeleteFlag(1);
        request.setChannelLogo("http://wwww/baodu.com");
        request.setChannelSlogn("我问问");
        request.setChannelType("h5");
        request.setId("2017070311092030807");
        request.setChannelShow(0);
        request.setChannelShowWay(2);
        request.setChannelListLogo("logo");
        DubboResponse<OtherChannelDetailResponse> c = otherChannelService.update(request);
        System.out.println(c);
    }

    @Test
    public void updateDeleteFlag() {
        DeleteOtherChannelDetailRequest request = new DeleteOtherChannelDetailRequest();
        request.setId("2017070310590040746");
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setDeleteFlag(1);
        DubboResponse<OtherChannelDetailResponse> response = otherChannelService.updateDeleteFlag(request);
        System.out.println(response);
    }


    @Test
    public void query() {
        QueryAllOtherChannelsRequest request = new QueryAllOtherChannelsRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setChannelType("h5");
        DubboResponse<List<OtherChannelDetailVo>> response = otherChannelService.queryAll(request);
        System.out.println(response);
    }

    @Test
    public void onOff() {
        OnOffOtherChannelRequest request = new OnOffOtherChannelRequest();
        request.setOnOff(0);
        request.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<Boolean> response = otherChannelService.onOff(request);
        System.out.println(response);
    }


    @Test
    public void offStatus() {
        BaseRequest request = new BaseRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<Integer> response = otherChannelService.offStartus(request);
        System.out.println(response);
    }

}
