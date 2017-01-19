package com.sdxd.cms.dubbo.outApi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sdxd.admin.entity.SystemVariable;
import com.sdxd.admin.service.SystemVariableService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutApiCustomer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OutApiCustomer.class);

  @Reference(version = "1.0.0")
  private SystemVariableService systemVariableService;

  public SystemVariable getZhugeParam(String code){
    return systemVariableService.getValueByCode(code);
  }

	public String getZhgUrl(){
		return "";
	}
}
