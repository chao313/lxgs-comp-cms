package com.sdxd.cms.service.impl;

import com.sdxd.cms.dao.AgreementTemplateDao;
import com.sdxd.cms.entity.AgreementTemplateManage;
import com.sdxd.cms.service.AgreementTemplateService;
import com.sdxd.framework.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
@Service
public class AgreementTemplateServiceImpl extends BaseServiceImpl<AgreementTemplateManage> implements AgreementTemplateService {

    @Resource
    private AgreementTemplateDao agreementTemplateDao ;

    @Override
    public boolean createAgreementTemplate(AgreementTemplateManage param) {
        int count = agreementTemplateDao.createAgreementTemplate(param);
        return count == 1;
    }

    @Override
    public boolean deleteAgreementTemplate(Integer id) {
        int count = agreementTemplateDao.deleteAgreementTemplate(id);
        return count == 1;
    }

    @Override
    public List<AgreementTemplateManage> queryAgreementTemplate(int pageStart, int pageSize) {
        List<AgreementTemplateManage> list = agreementTemplateDao.queryAgreementTemplate(pageStart,pageSize);
        if(list.size() == 0){
            return null;
        }
        return list;
    }

    @Override
    public int queryAgreementTemplateCount() {
        int count = agreementTemplateDao.queryAgreementTemplateCount();
        return count ;
    }

    @Override
    public AgreementTemplateManage queryByAgreementTitle(String agreementTitle) {
        AgreementTemplateManage manage = agreementTemplateDao.queryByAgreementTitle(agreementTitle);
        return manage;
    }

    @Override
    public AgreementTemplateManage queryById(Integer id) {
        AgreementTemplateManage manage = agreementTemplateDao.queryById(id);
        return manage;
    }

    @Override
    public List<AgreementTemplateManage> queryAll() {
        List<AgreementTemplateManage> list = agreementTemplateDao.getAllAgreement();
        return list;
    }
}
