package com.sdxd.cms.dubbo.outApi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.admin.dubbo.api.SystemVariableDubboService;
import com.sdxd.admin.dubbo.api.request.VariableCodeRequest;
import com.sdxd.admin.dubbo.api.response.SystemVariableResponse;
import com.sdxd.framework.dubbo.DubboResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutApiCustomer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OutApiCustomer.class);

  @Reference(version = "1.0.0")
  private SystemVariableDubboService dubboService;

  public DubboResponse<SystemVariableResponse> getZhugeParam(String code){
    VariableCodeRequest request = new VariableCodeRequest();
    request.setVariableCode(code);
    return dubboService.getValueByCodeStr(request);
  }

	public String getZhgUrl(){
		return "";
	}
}
