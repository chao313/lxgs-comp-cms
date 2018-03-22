package com.lxgs.cms.dubbo.api.request;

import com.sdxd.framework.dubbo.BaseRequest;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class CmsShareRequest extends BaseRequest{

	@NotNull
	private String id;

}
