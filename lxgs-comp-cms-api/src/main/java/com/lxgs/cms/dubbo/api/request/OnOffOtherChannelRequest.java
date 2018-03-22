package com.lxgs.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujie
 * @Date 2017/6/5
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OnOffOtherChannelRequest extends BaseRequest {

    private Integer onOff ; //开关 1：打开 ; 0 ：关闭

}
