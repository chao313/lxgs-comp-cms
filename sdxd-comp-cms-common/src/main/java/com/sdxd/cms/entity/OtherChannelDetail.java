package com.sdxd.cms.entity;

import com.sdxd.framework.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @author liujie
 * @Date 2017/5/26
 * 盛大小贷 其他平台h5信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Table(name="t_other_channel_detail")
public class OtherChannelDetail extends BaseEntity {
    private String channelLogo ;// 'logo地址
    private String channelName; //平台名称
    private String channelSlogn ;//平台slogn
    private String channelUrl ;//平台URL地址
    private Integer channelIndex ;//平台位置
    private String channelType ;//平台类型
    private Integer deleteFlag  ;//删除标志: 0未删除，1已删除
    private Integer channelShow;//是否显示  1：显示 0：不显示
}
