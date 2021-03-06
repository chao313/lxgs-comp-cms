package com.lxgs.cms.test;

import com.lxgs.cms.AgreementTemplateService;
import com.lxgs.cms.dubbo.api.pojo.AgreementTemplateVo;
import com.lxgs.cms.dubbo.api.request.AgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.request.DeleteAgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.request.QueryAgreementTemplateRequest;
import com.lxgs.cms.dubbo.api.response.AgreementTemplateResponse;
import com.lxgs.cms.dubbo.api.response.DeleteAgreementTemplateResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.DubboResponse;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
public class AgreementTemplateTest extends BaseTest {

    @Resource
    private AgreementTemplateService agreementTemplateService ;

    @Test
    public void create(){
        AgreementTemplateRequest request = new AgreementTemplateRequest();
        request.setUseType("财务");
        request.setPageId("1");
        request.setAgreementTitle("协议模板");
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setAgreementUrl("www.baidu.com");
        DubboResponse<AgreementTemplateResponse> c = agreementTemplateService.create(request);
        System.out.println(c);
    }

    @Test
    public void delete(){
        DeleteAgreementTemplateRequest request = new DeleteAgreementTemplateRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        request.setId(1);
        DubboResponse<DeleteAgreementTemplateResponse> d = agreementTemplateService.delete(request);
        System.out.println(d);
    }

    @Test
    public void query(){
        QueryAgreementTemplateRequest request = new QueryAgreementTemplateRequest();
        request.setRequestId(BillNoUtils.GenerateBillNo());
        DubboResponse<PaginationSupport<AgreementTemplateVo>> c =  agreementTemplateService.list(request);
        DubboResponse<Integer> d = agreementTemplateService.count(request);
        DubboResponse<List<AgreementTemplateVo>> all = agreementTemplateService.queryAll(request);
        System.out.println(c);
        System.out.println(d);
    }
}
