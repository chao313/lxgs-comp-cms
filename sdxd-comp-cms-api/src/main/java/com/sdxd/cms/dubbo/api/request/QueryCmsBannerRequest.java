package com.sdxd.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class QueryCmsBannerRequest extends BaseRequest{

	private String id;//d 可以为空
	private String name;//图片名  可以为空
	private String imageCode;//图片code  可以为空
	private String type;//类型
	private String pageId;//页面id
	private String position;//页面位置
}
