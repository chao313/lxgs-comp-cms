package com.lxgs.cms.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lxgs.cms.constants.EventType;
import com.lxgs.cms.constants.ZhuGeVar;
import com.lxgs.cms.dubbo.api.request.zhuge.EventPr;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.lxgs.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.lxgs.cms.dubbo.api.response.ZhugeResponse;
import com.lxgs.cms.dubbo.outApi.OutApiCustomer;
import com.lxgs.cms.service.ApproveDoneEventService;
import com.lxgs.cms.zhuge.util.ZhugeUtil;
import com.sdxd.common.mq.pojo.approve.ApproveDone;
import com.sdxd.common.utils.BillNoUtils;

@Service
public class ApproveDoneEventServiceImpl implements ApproveDoneEventService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApproveDoneEventServiceImpl.class);
	@Resource
	private OutApiCustomer outApiCustomer;

	@Override
	public ZhugeResponse pushApproveDoneZhuge(ApproveDone approveDone) {
		if(approveDone!=null && approveDone.getApproveTime() == null){
			approveDone.setApproveTime(new Date());
		}
		String time = (approveDone.getApproveTime().getTime() + "").substring(0, 10);
		ZhugeEventRequest eventRequest = new ZhugeEventRequest();
		eventRequest.setTs(time);
		eventRequest.setCuid(approveDone.getUserId());
		// data中的per属性
		EventPr eventPer = new EventPr();
		// data属性值
		ZhugeEventData zhugeEventData = new ZhugeEventData();
		zhugeEventData.setTs(time);
		if (approveDone.getResult() == 1) {
			zhugeEventData.setEid(EventType.APPROVE_ENT_PASS.getDesc());
		} else {
			zhugeEventData.setEid(EventType.APPROVE_ENT_REF.getDesc());
		}
		zhugeEventData.setPr(eventPer);
		eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
		eventRequest.setData(new ZhugeEventData[] { zhugeEventData });
		String apiUrl = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_URL.getCode());
		String appKey = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_APPKEY.getCode());
		String secretKey = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_SECRETKEY.getCode());
		eventRequest.setAk(appKey);
		String keys = ZhugeUtil.setKey(appKey, secretKey);
		String json = JSON.toJSONString(eventRequest);
		LOGGER.info("诸葛接口调用，param:{},keys:{}",json,keys);
		ZhugeResponse response = ZhugeUtil.invoke(apiUrl, json, keys);
		LOGGER.info("诸葛接口调用，response:{}",JSONObject.toJSONString(response));
		return response;
	}

	@Override
	public ZhugeResponse pushLoanZhuge(Long userId, Date eventTime, EventType evenType) {
		if(eventTime==null){
			eventTime = new Date();
		}
		String time = (eventTime.getTime() + "").substring(0, 10);
		ZhugeEventRequest eventRequest = new ZhugeEventRequest();
		eventRequest.setTs(time);
		eventRequest.setCuid(String.valueOf(userId));
		//eventRequest.setDebug(1);
		// data中的per属性
		EventPr eventPer = new EventPr();
		// data属性值
		ZhugeEventData zhugeEventData = new ZhugeEventData();
		zhugeEventData.setTs(time);
		zhugeEventData.setEid(evenType.getDesc());
		zhugeEventData.setPr(eventPer);
		String apiUrl = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_URL.getCode());
		String appKey = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_APPKEY.getCode());
		String secretKey = outApiCustomer.getZhugeParam(ZhuGeVar.ZHUGE_API_SECRETKEY.getCode());
		eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
		eventRequest.setAk(appKey);
		eventRequest.setData(new ZhugeEventData[] { zhugeEventData });
		String keys = ZhugeUtil.setKey(appKey, secretKey);
		String json = JSON.toJSONString(eventRequest);
		LOGGER.info("诸葛接口调用，param:{},keys:{}",json,keys);
		ZhugeResponse response = ZhugeUtil.invoke(apiUrl, json, keys);
		LOGGER.info("诸葛接口调用，response:{}",JSONObject.toJSONString(response));
		return response;
	}

}
