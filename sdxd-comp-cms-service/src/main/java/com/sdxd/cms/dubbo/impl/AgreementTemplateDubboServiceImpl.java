package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.admin.dubbo.api.response.AdminUserResponse;
import com.sdxd.cms.dubbo.api.AgreementTemplateDubboService;
import com.sdxd.cms.dubbo.api.pojo.AgreementTemplateVo;
import com.sdxd.cms.dubbo.api.request.AgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.request.DeleteAgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.request.QueryAgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.response.AgreementTemplateResponse;
import com.sdxd.cms.dubbo.api.response.CmsShareResponse;
import com.sdxd.cms.dubbo.api.response.DeleteAgreementTemplateResponse;
import com.sdxd.cms.entity.AgreementTemplateManage;
import com.sdxd.cms.service.AgreementTemplateService;
import com.sdxd.common.utils.BeanUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Service(interfaceName = "com.sdxd.cms.dubbo.api.AgreementTemplateDubboService", validation = "true", version = "1.0.0", timeout = 30000)

public class AgreementTemplateDubboServiceImpl implements AgreementTemplateDubboService {

    private Logger LOGGER = LoggerFactory.getLogger(AgreementTemplateDubboServiceImpl.class);

    @Autowired
    private AgreementTemplateService agreementTemplateService ;

    @Override
    public DubboResponse<AgreementTemplateResponse> createAgreementTemplate(AgreementTemplateRequest request) {
        DubboResponse<AgreementTemplateResponse> response = new DubboResponse<AgreementTemplateResponse>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        AgreementTemplateManage  manage =  new AgreementTemplateManage() ;
        manage.setAgreementTitle(request.getAgreementTitle());
        manage.setAgreementUrl(request.getAgreementUrl());
        manage.setPageId(request.getPageId());
        manage.setUseType(request.getUseType());
        manage.setCreateTime(new Date());
        manage.setUpdateTime(new Date());
        manage.setDeleteFlag(0); //默认为可用
        LOGGER.info("【协议模板】 ====================================>> 创建协议 ,参数 ,{}", JSONObject.toJSON(manage));
        try {
            //改协议已存在
            AgreementTemplateManage agreementTemplateManage = agreementTemplateService.queryByAgreementTitle(request.getAgreementTitle());
            if (agreementTemplateManage != null){
                response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                return response ;
            }

            boolean success = agreementTemplateService.createAgreementTemplate(manage);
            AgreementTemplateResponse t =  new AgreementTemplateResponse() ;
            t.setSuccess(success);
            response.setData(t);
        }catch (Exception e){
            LOGGER.error("【协议模板】 ====================================>> 新建协议 bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    @Override
    public DubboResponse<DeleteAgreementTemplateResponse> deleteAgreementTemplate(DeleteAgreementTemplateRequest request) {
        DubboResponse<DeleteAgreementTemplateResponse> response = new DubboResponse<DeleteAgreementTemplateResponse> ();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        Integer id = request.getId();
        LOGGER.info("【协议模板】 ====================================>> 删除协议, 协议id={}",id);
        try {
            //该条协议不存在
            AgreementTemplateManage agreementTemplateManage = agreementTemplateService.queryById(id);
            if(agreementTemplateManage == null){
                response.setMsg(Constants.System.PARAMS_INVALID_MSG);
                return response ;
            }

            boolean success = agreementTemplateService.deleteAgreementTemplate(id);
            DeleteAgreementTemplateResponse t = new DeleteAgreementTemplateResponse() ;
            t.setSuccess(success);
        }catch (Exception e){
            LOGGER.error("【协议模板】 ====================================>> 删除协议  bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<PaginationSupport<AgreementTemplateVo>> queryAgreementTemplate(QueryAgreementTemplateRequest request) {
        DubboResponse<PaginationSupport<AgreementTemplateVo>> response = new DubboResponse<>();
        response.setStatus(Constants.System.OK);
        response.setError(Constants.System.SERVER_SUCCESS);
        int pageStart = (request.getStartItem()!=null?request.getStartItem():0);
        int pageSize = (request.getPageSize()!=null?request.getPageSize():15);
        try {
            List<AgreementTemplateManage> list = agreementTemplateService.queryAgreementTemplate(pageStart,pageSize);
            if(list != null){
                LOGGER.error("【协议模板】 ====================================>> 协议列表 size= {}",list.size());
                List<AgreementTemplateVo> voList = new ArrayList<>(list.size());
                for(AgreementTemplateManage manage :list){
                    voList.add(convert(manage));
                }
                PaginationSupport paginationSupport = new PaginationSupport(voList, -1, request.getPageSize(), request.getCurrentPage());
                response.setData(paginationSupport);
            }
        }catch (Exception e){
            LOGGER.error("【协议模板】 ====================================>> 协议列表  bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    @Override
    public DubboResponse<Integer> queryAgreementTemplateCount(QueryAgreementTemplateRequest request) {
        DubboResponse<Integer> response = new DubboResponse<>();
        response.setStatus(Constants.System.OK);
        response.setError(Constants.System.SERVER_SUCCESS);
        try{
            int  count  = agreementTemplateService.queryAgreementTemplateCount();
            LOGGER.error("【协议模板】 ====================================>> 协议列表总数 {}", count);
            response.setData(count);
        }catch (Exception e){
            LOGGER.error("【协议模板】 ====================================>> 协议列表总数  bean copy error",e);
            response.setStatus(Constants.System.FAIL);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }
        return response;
    }

    private AgreementTemplateVo convert(AgreementTemplateManage manage) {
        AgreementTemplateVo pojo = new AgreementTemplateVo();
        try {
            BeanUtils.copyProperties(pojo, manage);
        } catch (Exception e) {
            LOGGER.error("Copy properties Error!", e);
        }
        return pojo;
    }
}
