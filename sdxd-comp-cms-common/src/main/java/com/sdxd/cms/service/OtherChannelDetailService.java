package com.sdxd.cms.service;

import com.sdxd.cms.entity.OtherChannelDetail;
import com.sdxd.framework.service.BaseService;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
public interface OtherChannelDetailService extends BaseService<OtherChannelDetail> {
    //添加平台信息
    boolean saveOtherChannelDetail(OtherChannelDetail detail);

    //修改平台信息
    boolean updateOtherChannelDetail (OtherChannelDetail detail);

    //删除平台
    boolean deleteOtherChannelDetail(String id);

    //查询平台
    OtherChannelDetail queryByChannelName(String channelName,String channelType);

    //根据id查询平台
    OtherChannelDetail queryById(String id);

    //查询所有未删除平台
    List<OtherChannelDetail> queryAll();

    //平台总数
    int queryCount();

    //查询未删除平台列表(分页)
    List<OtherChannelDetail> query(int pageStart,int pageSize);

    OtherChannelDetail queryByChannelIndex (int channelIndex);

    OtherChannelDetail queryByIndexAndId(int channelIndex,String id);
}
