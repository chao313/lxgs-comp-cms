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
	private String image_code;//图片code
	private String image_url;//图片地址
	private String image_link;//图片连接地址
	private Integer image_order;//图片的顺序，
	private Integer delete_flag;
}
