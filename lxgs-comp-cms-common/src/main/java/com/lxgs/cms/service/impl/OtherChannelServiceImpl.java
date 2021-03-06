package com.lxgs.cms.service.impl;

import com.lxgs.cms.dao.OtherChannelDetailDao;
import com.lxgs.cms.entity.OtherChannelDetail;
import com.lxgs.cms.service.OtherChannelDetailService;
import com.sdxd.framework.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Service
public class OtherChannelServiceImpl extends BaseServiceImpl<OtherChannelDetail> implements OtherChannelDetailService {

    @Autowired
    private OtherChannelDetailDao otherChannelDetailDao ;

    @Override
    public boolean saveOtherChannelDetail(OtherChannelDetail detail) {
        int count = otherChannelDetailDao.saveOtherChannelDetail(detail);
        return count == 1;
    }

    @Override
    public boolean updateOtherChannelDetail(OtherChannelDetail detail) {
        int count = otherChannelDetailDao.updateOtherChannelDetail(detail);
        return  count == 1 ;
    }

    @Override
    public boolean updateDeleteFlag(String id,Integer deleteFlag) {
        int count  = otherChannelDetailDao.updateDeleteFlag(id,deleteFlag);
        return count == 1;
    }

    @Override
    public List<OtherChannelDetail> queryAll(String type) {
        List<OtherChannelDetail> list = otherChannelDetailDao.queryAll(type);
        if(list.size() == 0){
            return new ArrayList<>();
        }
        return list;
    }

    @Override
    public List<OtherChannelDetail> query(int pageStart,int pageSize) {
        List<OtherChannelDetail> list = otherChannelDetailDao.queryByPage(pageStart,pageSize);
        if(list.size() == 0){
            return new ArrayList<>() ;
        }
        return list;
    }

    @Override
    public OtherChannelDetail queryByChannelName(String channelName,String channelType) {
        OtherChannelDetail detail = otherChannelDetailDao.queryByChannelName(channelName,channelType);
        return detail;
    }

    @Override
    public OtherChannelDetail queryById(String id) {
        OtherChannelDetail detail = otherChannelDetailDao.queryById(id);
        return detail;
    }

    @Override
    public int queryCount() {
        int count = otherChannelDetailDao.queryCount();
        return count;
    }

    @Override
    public OtherChannelDetail queryByChannelIndex(int channelIndex){
      OtherChannelDetail otherChannelDetail =   otherChannelDetailDao.queryByChannelIndex(channelIndex);
      return otherChannelDetail;
    }

    @Override
    public OtherChannelDetail queryByIndexAndId(int channelIndex, String id) {
      OtherChannelDetail detail =   otherChannelDetailDao.queryByIndexAndId(channelIndex,id);
        return detail;
    }

    @Override
    public Boolean onOff(int channelShow) {
        int count = otherChannelDetailDao.onOff(channelShow);
        return count >= 1;
    }

    @Override
    public OtherChannelDetail offStatus() {
        OtherChannelDetail offStatus = otherChannelDetailDao.offStatus();
        return offStatus;
    }
}
