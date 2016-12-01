package com.sdxd.cms.dubbo.api.response;

import java.util.List;

import com.sdxd.cms.dubbo.api.pojo.CmsBannerVo;
import com.sdxd.framework.dubbo.BaseResponse;

import lombok.Data;
@Data
public class QueryCmdBannerResponse extends BaseResponse{

	private List<CmsBannerVo> list;
}
