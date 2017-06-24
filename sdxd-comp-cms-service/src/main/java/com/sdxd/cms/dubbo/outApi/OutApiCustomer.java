package com.sdxd.cms.dubbo.outApi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.admin.dubbo.api.SystemVariableDubboService;
import com.sdxd.admin.dubbo.api.constants.SystemVariableCode;
import com.sdxd.admin.dubbo.api.request.AppVesionRequest;
import com.sdxd.admin.dubbo.api.request.VariableCodeRequest;
import com.sdxd.admin.dubbo.api.response.AppVersionResponse;
import com.sdxd.admin.dubbo.api.response.SystemVariableResponse;
import com.sdxd.common.utils.BillNoUtils;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutApiCustomer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OutApiCustomer.class);

  @Reference(version = "1.0.0")
  private SystemVariableDubboService systemVariableDubboService;

 /* public DubboResponse<SystemVariableResponse> getZhugeParam(String code){
    VariableCodeRequest request = new VariableCodeRequest();
    request.setVariableCode(code);
    return systemVariableDubboService.getValueByCodeStr(request);
  }*/
  
	public String getZhugeParam(String code) {
		VariableCodeRequest request = new VariableCodeRequest();
		request.setRequestId(BillNoUtils.GenerateBillNo());
		request.setVariableCode(code);
		DubboResponse<SystemVariableResponse> response = systemVariableDubboService.getValueByCodeStr(request);
		if (response == null || !StringUtils.equals(Constants.System.OK, response.getStatus())
				|| !StringUtils.equals(Constants.System.SERVER_SUCCESS, response.getError())) {
			LOGGER.error("systemVariableDubboService->getValueByCode,request:{},response:{}",
					JSONObject.toJSONString(request), JSONObject.toJSONString(response));
			return null;
		}
		return response.getData() != null ? response.getData().getValue() : null;
	}

	public String getZhgUrl(){
		return "";
	}
}
