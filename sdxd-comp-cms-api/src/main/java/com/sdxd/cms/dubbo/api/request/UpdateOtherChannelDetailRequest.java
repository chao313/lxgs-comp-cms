package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateOtherChannelDetailRequest extends BaseRequest {

    private String channelLogo ;// 'logo地址
    private String channelName; //平台名称
    private String channelSlogn ;//平台slogn
    private String channelUrl ;//平台URL地址
    private Integer channelIndex ; //平台位置
    private String channelType ;//平台类型
    private String id ;
    private Integer deleteFlag ;
    private Integer channelShow ;// 是否显示该平台 1：显示 ; 0 ：不显示
    private String channelShowType;//渠道显示的方式
    private String channelImage;//列表图片来源
}
