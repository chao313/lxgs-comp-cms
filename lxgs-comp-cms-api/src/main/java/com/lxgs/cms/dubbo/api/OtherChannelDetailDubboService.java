package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.lxgs.cms.dubbo.api.request.*;
import com.lxgs.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
public interface OtherChannelDetailDubboService {

    //创建
    public DubboResponse<OtherChannelDetailResponse> save(OtherChannelDetailRequest request);

    //修改
    public DubboResponse<OtherChannelDetailResponse> update(UpdateOtherChannelDetailRequest request);

    //删除
    public DubboResponse<OtherChannelDetailResponse> updateDeleteFlag(DeleteOtherChannelDetailRequest request);

    //查询总数
    public DubboResponse<Integer> queryCount(BaseRequest request);

    //查询所有
    public DubboResponse<List<OtherChannelDetailVo>> queryAll(QueryAllOtherChannelsRequest request);

    //分页查询
    public DubboResponse<PaginationSupport<OtherChannelDetailVo>> query(QueryOtherChannelDetailRequest request);

    public DubboResponse<Boolean> onOff(OnOffOtherChannelRequest request);

    public DubboResponse<Integer> offStatus(BaseRequest request);
}
