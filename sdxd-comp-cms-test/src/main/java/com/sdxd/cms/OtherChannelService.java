package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.OtherChannelDetailDubboService;
import com.sdxd.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.sdxd.cms.dubbo.api.request.*;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Service
public class OtherChannelService {

    @Reference(version = "1.0.0")
    private OtherChannelDetailDubboService otherChannelDetailDubboService;

    public DubboResponse<OtherChannelDetailResponse> save(OtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = otherChannelDetailDubboService.save(request);
        return response;
    }

    public DubboResponse<OtherChannelDetailResponse> update(UpdateOtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = otherChannelDetailDubboService.update(request);
        return response;
    }

    public DubboResponse<OtherChannelDetailResponse> updateDeleteFlag(DeleteOtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = otherChannelDetailDubboService.updateDeleteFlag(request);
        return response;
    }

    //查询总数
    public DubboResponse<Integer> queryCount(BaseRequest request) {
        DubboResponse<Integer> response = otherChannelDetailDubboService.queryCount(request);
        return response;
    }

    //查询所有
    public DubboResponse<List<OtherChannelDetailVo>> queryAll(QueryAllOtherChannelsRequest request) {
        DubboResponse<List<OtherChannelDetailVo>> response = otherChannelDetailDubboService.queryAll(request);
        return response;
    }

    //分页查询
    public DubboResponse<PaginationSupport<OtherChannelDetailVo>> query(QueryOtherChannelDetailRequest request) {
        DubboResponse<PaginationSupport<OtherChannelDetailVo>> response = otherChannelDetailDubboService.query(request);
        return response;
    }

    public DubboResponse<Boolean> onOff(OnOffOtherChannelRequest request) {
        DubboResponse<Boolean> response = otherChannelDetailDubboService.onOff(request);
        return response;
    }

    public DubboResponse<Integer> offStartus(BaseRequest request) {
        DubboResponse<Integer> response = otherChannelDetailDubboService.offStatus(request);
        return response;
    }
}
