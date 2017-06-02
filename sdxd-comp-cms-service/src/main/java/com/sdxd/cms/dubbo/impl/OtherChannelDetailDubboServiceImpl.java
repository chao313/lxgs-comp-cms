package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sdxd.cms.dubbo.api.OtherChannelDetailDubboService;
import com.sdxd.cms.dubbo.api.pojo.AgreementTemplateVo;
import com.sdxd.cms.dubbo.api.pojo.OtherChannelDetailVo;
import com.sdxd.cms.dubbo.api.request.*;
import com.sdxd.cms.dubbo.api.response.OtherChannelDetailResponse;
import com.sdxd.cms.entity.AgreementTemplateManage;
import com.sdxd.cms.entity.OtherChannelDetail;
import com.sdxd.cms.service.OtherChannelDetailService;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Service(interfaceName = "com.sdxd.cms.dubbo.api.OtherChannelDetailDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class OtherChannelDetailDubboServiceImpl  implements OtherChannelDetailDubboService{

    private Logger LOGGER = LoggerFactory.getLogger(OtherChannelDetailDubboServiceImpl.class);

    @Resource
    private OtherChannelDetailService otherChannelDetailService ;

    @Override
    public DubboResponse<OtherChannelDetailResponse> save(OtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        OtherChannelDetail detail = new OtherChannelDetail();
        detail.setDeleteFlag(0); //默认为零 可用状态
        detail.setUpdateTime(new Date());
        detail.setCreateTime(new Date());
        detail.setChannelLogo(request.getChannelLogo());
        detail.setChannelName(request.getChannelName());
        detail.setChannelSlogn(request.getChannelSlogn());
        detail.setChannelUrl(request.getChannelUrl());
        detail.setChannelType(request.getChannelType());
        detail.setId(BillNoUtils.GenerateBillNo());
        try {
            //平台已存在
            OtherChannelDetail otherChannelDetail = otherChannelDetailService.queryByChannelName(request.getChannelName(),request.getChannelType());
            if (otherChannelDetail != null){
                response.setError(Constants.System.PARAMS_INVALID);
                response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                return response ;
            }
            if(request.getChannelIndex() != null){
                OtherChannelDetail  otherDetail =   otherChannelDetailService.queryByChannelIndex(request.getChannelIndex());
                if (otherDetail != null){
                    //当前位置已存在
                    response.setError(Constants.System.PARAMS_INVALID);
                    response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                    return response ;
                }else{
                    detail.setChannelIndex(request.getChannelIndex());
                }
            }
            LOGGER.error("【合作平台】 ====================================>> 创建平台参数 {}",request);
            boolean bool = otherChannelDetailService.saveOtherChannelDetail(detail);
            LOGGER.error("【合作平台】 ====================================>> 创建平台返回消息 {}",bool);
            OtherChannelDetailResponse t =  new OtherChannelDetailResponse() ;
            t.setSuccess(bool);
            response.setData(t);
        }catch (Exception e){
            LOGGER.error("【合作平台】 ====================================>> 创建平台 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<OtherChannelDetailResponse> update(UpdateOtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        OtherChannelDetail detail = new OtherChannelDetail() ;
        detail.setDeleteFlag(request.getDeleteFlag());
        detail.setUpdateTime(new Date());
        detail.setChannelLogo(request.getChannelLogo());
        detail.setChannelName(request.getChannelName());
        detail.setChannelSlogn(request.getChannelSlogn());
        detail.setChannelUrl(request.getChannelUrl());
        detail.setChannelType(request.getChannelType());
        detail.setId(request.getId());
        try {
            OtherChannelDetail otherChannelDetail = null;
            //平台已存在
            otherChannelDetail = otherChannelDetailService.queryById(request.getId());
            if (otherChannelDetail == null){
                response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                return response ;
            }

            if(request.getChannelIndex() != null){
                otherChannelDetail =   otherChannelDetailService.queryByIndexAndId(request.getChannelIndex(),request.getId());
                if (otherChannelDetail != null){
                    //当前位置已被其他平台占领，已无坑
                    response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                    return response ;
                }else{
                    detail.setChannelIndex(request.getChannelIndex());
                }
            }
            LOGGER.error("【合作平台】 ====================================>> 修改参数 {}",request);
            boolean bool = otherChannelDetailService.updateOtherChannelDetail(detail);
            LOGGER.error("【合作平台】 ====================================>> 修改返回消息 {}",bool);
            OtherChannelDetailResponse t =  new OtherChannelDetailResponse() ;
            t.setSuccess(bool);
            response.setData(t);
        }catch (Exception e){
            LOGGER.error("【合作平台】 ====================================>> 修改 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<OtherChannelDetailResponse> updateDeleteFlag(DeleteOtherChannelDetailRequest request) {
        DubboResponse<OtherChannelDetailResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        try{
            //萝卜干都没 吃不了
            OtherChannelDetail  otherChannelDetail= otherChannelDetailService.queryById(request.getId());
            if (otherChannelDetail == null){
                response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                return response ;
            }
            LOGGER.error("【合作平台】 ====================================>> 删除参数 {}",request);
            boolean bool = otherChannelDetailService.updateDeleteFlag(request.getId(),request.getDeleteFlag());
            LOGGER.error("【合作平台】 ====================================>> 删除返回消息 {}",bool);
            OtherChannelDetailResponse t =  new OtherChannelDetailResponse() ;
            t.setSuccess(bool);
            response.setData(t);
        }catch (Exception e){
            LOGGER.error("【合作平台】 ====================================>> 删除平台 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    @Override
    public DubboResponse<Integer> queryCount(BaseRequest request) {
        DubboResponse<Integer> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        try{

            LOGGER.error("【合作平台】 ====================================>> 查询总数参数 {}",request);
            int count = otherChannelDetailService.queryCount();
            LOGGER.error("【合作平台】 ====================================>> 查询总数返回消息 {}",count);
            response.setData(count);
        }catch (Exception e){
            LOGGER.error("【合作平台】 ====================================>> 查询总数平台 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<List<OtherChannelDetailVo>> queryAll(QueryAllOtherChannelsRequest request) {
        DubboResponse<List<OtherChannelDetailVo>> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        String channelType = request.getChannelType();
        try{

            List<OtherChannelDetail> list = otherChannelDetailService.queryAll(channelType);
            LOGGER.error("【合作平台】 ====================================>> 查询总列表返回消息 {}",list.size());
            if(list != null){
                List<OtherChannelDetailVo> voList = new ArrayList<>(list.size());
                for(OtherChannelDetail vo :list){
                    voList.add(convert(vo));
                }
                response.setData(voList);
            }
        }catch (Exception e){
            LOGGER.error("【合作平台】 ====================================>> 查询总数平台 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<PaginationSupport<OtherChannelDetailVo>> query(QueryOtherChannelDetailRequest request) {
        DubboResponse<PaginationSupport<OtherChannelDetailVo>> response = new DubboResponse<>();
        response.setStatus(Constants.System.OK);
        response.setError(Constants.System.SERVER_SUCCESS);
        int pageStart = (request.getStartItem()!=null?request.getStartItem():0);
        int pageSize = (request.getPageSize()!=null?request.getPageSize():15);
        try {
            List<OtherChannelDetail> list = otherChannelDetailService.query(pageStart,pageSize);
            if(list != null){
                LOGGER.error("【合作平台】 ====================================>> 平台列表 size= {}",list.size());
                List<OtherChannelDetailVo> voList = new ArrayList<>(list.size());
                for(OtherChannelDetail vo :list){
                    voList.add(convert(vo));
                }
                PaginationSupport paginationSupport = new PaginationSupport(voList, -1, request.getPageSize(), request.getCurrentPage());
                response.setData(paginationSupport);
            }
        }catch (Exception e){
            LOGGER.error("【协议模板】 ====================================>> 平台列表  bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    private OtherChannelDetailVo convert(OtherChannelDetail detail) {
        OtherChannelDetailVo pojo = new OtherChannelDetailVo();
        try {
            BeanUtils.copyProperties(pojo, detail);
        } catch (Exception e) {
            LOGGER.error("Copy properties Error!", e);
        }
        return pojo;
    }
}