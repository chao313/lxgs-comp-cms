package com.lxgs.cms.dubbo.api;

import com.lxgs.cms.dubbo.api.pojo.AgreementTemplateVo;
import com.lxgs.cms.dubbo.api.request.AgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.request.DeleteAgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.request.QueryAgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.response.AgreementTemplateResponse;
import com.lxgs.cms.dubbo.api.response.DeleteAgreementTemplateResponse;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.DubboResponse;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
public interface AgreementTemplateDubboService {

    //创建协议模板
    public DubboResponse<AgreementTemplateResponse> createAgreementTemplate (AgreementTemplateRequest request);

    //删除协议模板
    public DubboResponse<DeleteAgreementTemplateResponse> deleteAgreementTemplate (DeleteAgreementTemplateRequest request);

    //协议列表
    public DubboResponse<PaginationSupport<AgreementTemplateVo>> queryAgreementTemplate(QueryAgreementTemplateRequest request);

    //协议总条数
    public DubboResponse<Integer> queryAgreementTemplateCount(QueryAgreementTemplateRequest request);

    //查询所有协议
    public DubboResponse<List<AgreementTemplateVo>> queryAll();

}
