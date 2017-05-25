package com.sdxd.cms.dao;

import com.sdxd.cms.entity.AgreementTemplateManage;
import com.sdxd.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujie
 * @Date 2017/5/4
 * 盛大小贷
 */
public interface AgreementTemplateDao extends BaseDao<AgreementTemplateManage> {

    //插入协议模板
    int createAgreementTemplate(AgreementTemplateManage param);

    //删处协议模板
    int deleteAgreementTemplate(@Param("id") Integer id);

    //协议模板列表
    List<AgreementTemplateManage> queryAgreementTemplate (@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //查询总数
    int queryAgreementTemplateCount();

    AgreementTemplateManage queryByAgreementTitle (@Param("agreementTitle") String agreementTitle);

    AgreementTemplateManage queryById (@Param("id") Integer id );

    List<AgreementTemplateManage> getAllAgreement ();
}
