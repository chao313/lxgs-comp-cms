package com.sdxd.cms.test;

import com.sdxd.cms.OtherChannelService;
import com.sdxd.cms.dubbo.api.request.OtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dubbo.DubboResponse;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
public class ChannelDubboTest extends BaseTest {

    @Resource
    private OtherChannelService otherChannelService ;

    @Test
    public void create(){
        OtherChannelDetailRequest request = new OtherChannelDetailRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setChannelUrl("http://wwww.baidu.com");
        request.setChannelName("芝麻");
        request.setChannelIndex(2);
        request.setChannelLogo("http://wwww/baodu.com");
        request.setChannelSlogn("我问问");
        request.setChannelType("app");
        DubboResponse<OtherChannelDetailResponse> c = otherChannelService.save(request);
        System.out.println(c);
    }
}
