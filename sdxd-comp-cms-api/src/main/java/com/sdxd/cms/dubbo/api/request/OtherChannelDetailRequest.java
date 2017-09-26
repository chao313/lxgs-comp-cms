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
public class OtherChannelDetailRequest extends BaseRequest {

    private String channelLogo ;// 'logo地址
    private String channelName; //平台名称
    private String channelSlogn ;//平台slogn
    private String channelUrl ;//平台URL地址
    private Integer channelIndex ; //平台位置
    private String channelType ;//平台类型
    private Integer channelShow ;//平台是否显示 1：显示 0 ：不显示
    private Integer channelShowWay;//渠道显示的方式
    private String channelListLogo;//列表图片来源

}
