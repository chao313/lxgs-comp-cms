package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsBannerRequest extends BaseRequest{
	
	private String id;//保存的时候为空 ,更新时必填
	private String name;
	private String type;//类型：WEB，APP，H5,
	private String imageCode;//图片code
	private String imageUrl;//图片地址
	private String imageLink;//图片连接地址
	private Integer imageOrder;//图片的顺序，
	
}
