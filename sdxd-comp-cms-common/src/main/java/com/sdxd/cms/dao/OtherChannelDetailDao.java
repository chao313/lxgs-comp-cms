package com.sdxd.cms.dao;


import com.sdxd.cms.entity.OtherChannelDetail;
import com.sdxd.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
public interface OtherChannelDetailDao extends BaseDao<OtherChannelDetail> {

    //添加平台信息
    int saveOtherChannelDetail(OtherChannelDetail detail);

    //修改平台信息
    int updateOtherChannelDetail (OtherChannelDetail detail);

    //删除平台
    int deleteOtherChannelDetail(@Param("id") String id);

    //查询平台
    OtherChannelDetail queryByChannelName(@Param("channelName") String channelName,@Param("channelType") String channelType);

    OtherChannelDetail queryById(@Param("id")String id);

    //查询所有未删除平台
    List<OtherChannelDetail> queryAll();

    int queryCount();

    //查询未删除平台列表(分页)
    List<OtherChannelDetail> query(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    OtherChannelDetail queryByChannelIndex(@Param("channelIndex") Integer channelIndex);

    OtherChannelDetail queryByIndexAndId(@Param("channelIndex") Integer channelIndex,@Param("id") String id);

}
