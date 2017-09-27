package com.sdxd.cms.dubbo.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷
 */
@Data
public class OtherChannelDetailVo implements Serializable {

    private String id ;
    private String channelLogo ;// 'logo地址
    private String channelName; //平台名称
    private String channelSlogn ;//平台slogn
    private String channelUrl ;//平台URL地址
    private Integer channelIndex ;//平台位置
    private Date createTime ;
    private Date updateTime ;
    private Integer deleteFlag  ;//删除标志: 0未删除，1已删除
    private String channelType ; //平台类型
    private Integer channelShow ;//平台是否显示 1：显示 0：不显示
    private Integer channelShowType;//渠道显示的方式
    private String channelImage;//列表图片来源

}
