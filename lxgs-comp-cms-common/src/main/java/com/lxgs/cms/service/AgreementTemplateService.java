package com.lxgs.cms.service;

import com.lxgs.cms.entity.AgreementTemplateManage;
import com.sdxd.framework.service.BaseService;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
public interface AgreementTemplateService  extends BaseService<AgreementTemplateManage>  {

    //创建
    boolean createAgreementTemplate(AgreementTemplateManage param);
    //删除
    boolean deleteAgreementTemplate(Integer id);
    //查询
    List<AgreementTemplateManage> queryAgreementTemplate(int pageStart, int pageSize);
    //查询总数
    int queryAgreementTemplateCount();
    //根据协议模板标题查询
    AgreementTemplateManage queryByAgreementTitle(String agreementTitle);
    //根据协议模板id查询
    AgreementTemplateManage queryById (Integer id );

    //查询所有
    List<AgreementTemplateManage> queryAll();
}
