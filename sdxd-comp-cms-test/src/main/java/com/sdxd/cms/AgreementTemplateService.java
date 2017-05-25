package com.sdxd.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.cms.dubbo.api.AgreementTemplateDubboService;
import com.sdxd.cms.dubbo.api.pojo.AgreementTemplateVo;
import com.sdxd.cms.dubbo.api.request.AgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.request.DeleteAgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.request.QueryAgreementTemplateRequest;
import com.sdxd.cms.dubbo.api.response.AgreementTemplateResponse;
import com.sdxd.cms.dubbo.api.response.DeleteAgreementTemplateResponse;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.BaseRequest;
import com.sdxd.framework.dubbo.DubboResponse;
import javafx.scene.control.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Service
public class AgreementTemplateService {

    @Reference(version = "1.0.0")
    private AgreementTemplateDubboService agreementTemplateDubboService;

    public DubboResponse<AgreementTemplateResponse> create (AgreementTemplateRequest  request){
        return agreementTemplateDubboService.createAgreementTemplate(request);
    }

    public  DubboResponse<DeleteAgreementTemplateResponse> delete(DeleteAgreementTemplateRequest request){
        return agreementTemplateDubboService.deleteAgreementTemplate(request);
    }

    public DubboResponse<PaginationSupport<AgreementTemplateVo>> list (QueryAgreementTemplateRequest request){
        return agreementTemplateDubboService.queryAgreementTemplate(request);
    }

    public DubboResponse<Integer> count (QueryAgreementTemplateRequest request){
        return agreementTemplateDubboService.queryAgreementTemplateCount(request);
    }

    public DubboResponse<List<AgreementTemplateVo>> queryAll(BaseRequest request){
        return agreementTemplateDubboService.queryAll();
    }
}
