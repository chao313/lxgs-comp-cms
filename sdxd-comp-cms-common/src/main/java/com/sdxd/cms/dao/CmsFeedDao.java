package com.sdxd.cms.dao;

import com.sdxd.cms.entity.CmsFeed;
import com.sdxd.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dao
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

    List<CmsFeed> searchPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
}
