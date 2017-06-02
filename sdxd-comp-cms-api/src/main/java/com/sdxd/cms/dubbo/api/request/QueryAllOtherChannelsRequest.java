package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujie
 * @Date 2017/6/2
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryAllOtherChannelsRequest  extends BaseRequest{

    private String channelType; //渠道类型，all null 查询所有
}
