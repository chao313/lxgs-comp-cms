package com.sdxd.cms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.request.zhuge.EventPr;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventData;
import com.sdxd.cms.dubbo.api.request.zhuge.ZhugeEventRequest;
import com.sdxd.cms.dubbo.api.response.ZhugeResponse;
import com.sdxd.cms.dubbo.outApi.OutApiCustomer;
import com.sdxd.cms.service.ApproveDoneEventService;
import com.sdxd.cms.zhuge.util.ZhugeUtil;
import com.sdxd.common.mq.pojo.approve.ApproveDone;
import com.sdxd.common.utils.BillNoUtils;

@Service
public class ApproveDoneEventServiceImpl implements ApproveDoneEventService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApproveDoneEventServiceImpl.class);

	private OutApiCustomer outApiCustomer;
	@Override
	public ZhugeResponse pushZhuGe(ApproveDone approveDone) {
		String time = (approveDone.getApproveTime().getTime() + "").substring(0, 10);
		ZhugeEventRequest eventRequest = new ZhugeEventRequest();
		eventRequest.setTs(time);
		eventRequest.setCuid(approveDone.getUserId());
		// data中的per属性
		EventPr eventPer = new EventPr();
		// data属性值
		ZhugeEventData<EventPr> zhugeEventData = new ZhugeEventData<>();
		zhugeEventData.setTs(time);
		if (approveDone.getResult() == 1) {
			zhugeEventData.setEid("信审通过");
		} else {
			zhugeEventData.setEid("信审拒绝");
		}
		zhugeEventData.setPr(eventPer);
		eventRequest.setRequestId(BillNoUtils.GenerateBillNo());
		eventRequest.setData(new ZhugeEventData[] { zhugeEventData });
		String apiUrl = outApiCustomer.getZhgUrl();
		String json = JSON.toJSONString(eventRequest);
		ZhugeResponse response = ZhugeUtil.invoke(apiUrl, json);
		LOGGER.info(JSONObject.toJSONString(response));
		return response;
	}

}
