package com.lxgs.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.lxgs.cms.dubbo.api.request
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/21    wenzhou.xu              Created
 */
@Data
public class CmsFeedPageRequest extends PageRequest {
    private List<Integer> templateList;
    private Integer display;
}
