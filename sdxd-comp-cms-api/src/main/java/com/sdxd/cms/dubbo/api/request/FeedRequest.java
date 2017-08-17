package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dubbo.api.request.zhuge
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
public class FeedRequest extends BaseRequest {
    private String id;
    private String title;
    private String tag;
    private Integer display;
    private List<String> imgList;
    private String feedUrl;
    private String from;
    private Integer comment;
}
