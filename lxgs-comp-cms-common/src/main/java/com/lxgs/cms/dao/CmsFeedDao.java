package com.lxgs.cms.dao;

import com.lxgs.cms.entity.CmsFeed;
import com.sdxd.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.lxgs.cms.dao
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
public interface CmsFeedDao extends BaseDao<CmsFeed> {

    List<CmsFeed> searchPage(@Param("templateList") List<Integer> templateList,
                             @Param("isDisplay") Integer isDisplay,
                             @Param("startIndex") Integer startIndex,
                             @Param("pageSize") Integer pageSize);
}
