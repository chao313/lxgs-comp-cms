package com.sdxd.cms.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dubbo.api.pojo
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/17    wenzhou.xu              Created
 */
@Data
public class CmsFeedVo implements Serializable {
    private String id;
    private String title;
    private String tag;
    private Integer display;
    private List<String> imgList;
    private String feedUrl;
    private String from;
    private Integer comment;
}
