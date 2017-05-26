package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.OtherChannelDetailDubboService;
import com.sdxd.cms.dubbo.api.request.DeleteOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.OtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.UpdateOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.framework.dubbo.DubboResponse;
import org.springframework.stereotype.Service;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Service
public class OtherChannelService {

    @Reference(version = "1.0.1")
    private OtherChannelDetailDubboService otherChannelDetailDubboService  ;

    public DubboResponse<OtherChannelDetailResponse> save(OtherChannelDetailRequest request){
        DubboResponse<OtherChannelDetailResponse> response = otherChannelDetailDubboService.save(request);
        return response ;
    }

    public DubboResponse<OtherChannelDetailResponse> update(UpdateOtherChannelDetailRequest request){
        DubboResponse<OtherChannelDetailResponse> response = otherChannelDetailDubboService.update(request);
        return  response;
    }

    public DubboResponse<OtherChannelDetailResponse> updateDeleteFlag(DeleteOtherChannelDetailRequest request){
        DubboResponse<OtherChannelDetailResponse> response =  otherChannelDetailDubboService.updateDeleteFlag(request);
        return response ;
    }
}
