package com.sdxd.cms.dubbo.api;

import com.sdxd.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.sdxd.cms.dubbo.api.request.DeleteOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.OtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.QueryOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.request.UpdateOtherChannelDetailRequest;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
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
    DubboResponse<OtherChannelDetailResponse> save(OtherChannelDetailRequest request);

    //修改
    DubboResponse<OtherChannelDetailResponse> update(UpdateOtherChannelDetailRequest request);

    //删除
    DubboResponse<OtherChannelDetailResponse> delete(DeleteOtherChannelDetailRequest request);

    //查询总数
    DubboResponse<Integer> queryCount(BaseRequest request);

    //查询所有
    DubboResponse<List<OtherChannelDetailVo>> queryAll(BaseRequest request);

    //分页查询
    DubboResponse<PaginationSupport<OtherChannelDetailVo>> query(QueryOtherChannelDetailRequest request);
}
