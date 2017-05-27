package com.sdxd.cms.test;

import com.sdxd.cms.OtherChannelService;
import com.sdxd.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.sdxd.cms.dubbo.api.request.DeleteOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.OtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.QueryOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.UpdateOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import org.hyperic.sigar.cmd.Du;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

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
        request.setChannelType("h5");
        DubboResponse<OtherChannelDetailResponse> c = otherChannelService.save(request);
        System.out.println(c);
    }

    @Test
    public void update(){
        UpdateOtherChannelDetailRequest request = new UpdateOtherChannelDetailRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setChannelUrl("http://wwww.baidu.com");
        request.setChannelName("芝麻");
        request.setChannelIndex(2);
        request.setDeleteFlag(1);
        request.setChannelLogo("http://wwww/baodu.com");
        request.setChannelSlogn("我问问");
        request.setChannelType("h5");
        request.setId("2017052618192156502");
        DubboResponse<OtherChannelDetailResponse> c = otherChannelService.update(request);
        System.out.println(c);
    }

    @Test
    public void updateDeleteFlag(){
        DeleteOtherChannelDetailRequest request = new DeleteOtherChannelDetailRequest();
        request.setId("2017052618192156502");
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setDeleteFlag(1);
        DubboResponse<OtherChannelDetailResponse> response = otherChannelService.updateDeleteFlag(request);
        System.out.println(response);
    }


    @Test
    public void query(){
        BaseRequest request = new BaseRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<List<OtherChannelDetailVo>> response = otherChannelService.queryAll(request);
        DubboResponse<Integer> c = otherChannelService.queryCount(request);

        QueryOtherChannelDetailRequest request1 = new QueryOtherChannelDetailRequest();
        request1.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<PaginationSupport<OtherChannelDetailVo>> b = otherChannelService.query(request1);

        System.out.println(c);
    }

}
