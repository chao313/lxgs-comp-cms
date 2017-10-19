package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sdxd.cms.dubbo.api.CmsSuspensionSettingDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsSuspensionSettingVo;
import com.sdxd.cms.dubbo.api.request.CmsSuspensionSettingRequest;
import com.sdxd.cms.dubbo.api.response.CmsSuspensionSettingListResponse;
import com.sdxd.cms.dubbo.api.response.CmsSuspensionSettingResponse;
import com.sdxd.cms.entity.CmsSuspensionSetting;
import com.sdxd.cms.service.CmsSuspensionSettingService;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dubbo.DubboResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmsSuspensionSettingDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsSuspensionSettingDubboServiceImpl implements CmsSuspensionSettingDubboService {

    private Logger logger = LoggerFactory.getLogger(CmsSuspensionSettingDubboServiceImpl.class);

    @Resource
    private CmsSuspensionSettingService cmsSuspensionSettingService;

    @Override
    public DubboResponse<CmsSuspensionSettingListResponse> findAll(CmsSuspensionSettingRequest request) {
        DubboResponse<CmsSuspensionSettingListResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);
        List<CmsSuspensionSetting> cmsSuspensionSettingList = cmsSuspensionSettingService.getAll();
        List<CmsSuspensionSettingVo> cmsSuspensionSettingVoList = new ArrayList<>();
        for (CmsSuspensionSetting setting : cmsSuspensionSettingList) {
            CmsSuspensionSettingVo vo = new CmsSuspensionSettingVo();
            vo.setId(setting.getId());
            vo.setActivityName(setting.getActivityName());
            vo.setImageUrl(setting.getImageUrl());
            vo.setRedirectUrl(setting.getRedirectUrl());
            vo.setCreateTime(setting.getCreateTime());
            vo.setUpdateTime(setting.getUpdateTime());
            cmsSuspensionSettingVoList.add(vo);
        }
        CmsSuspensionSettingListResponse cmsSuspensionSettingListResponse = new CmsSuspensionSettingListResponse();
        cmsSuspensionSettingListResponse.setCmsSuspensionSettingVoList(cmsSuspensionSettingVoList);
        response.setData(cmsSuspensionSettingListResponse);
        return response;
    }

    @Override
    public DubboResponse<CmsSuspensionSettingResponse> findById(CmsSuspensionSettingRequest request) {
        DubboResponse<CmsSuspensionSettingResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        String id = request.getId();
        CmsSuspensionSetting cmsSuspensionSetting = cmsSuspensionSettingService.getById(id);

        CmsSuspensionSettingVo vo = request.getCmsSuspensionSettingVo();
        vo.setId(cmsSuspensionSetting.getId());
        vo.setActivityName(cmsSuspensionSetting.getActivityName());
        vo.setImageUrl(cmsSuspensionSetting.getImageUrl());
        vo.setRedirectUrl(cmsSuspensionSetting.getRedirectUrl());
        vo.setCreateTime(cmsSuspensionSetting.getCreateTime());
        vo.setUpdateTime(cmsSuspensionSetting.getUpdateTime());
        CmsSuspensionSettingResponse cmsSuspensionSettingResponse = new CmsSuspensionSettingResponse();
        cmsSuspensionSettingResponse.setCmsSuspensionSettingVo(vo);
        response.setData(cmsSuspensionSettingResponse);

        return response;
    }

    @Override
    public DubboResponse<CmsSuspensionSettingResponse> saveCmsSuspensionSetting(CmsSuspensionSettingRequest request) {
        DubboResponse<CmsSuspensionSettingResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        CmsSuspensionSettingVo vo = request.getCmsSuspensionSettingVo();
        CmsSuspensionSetting cmsSuspensionSetting = new CmsSuspensionSetting();
        cmsSuspensionSetting.setActivityName(vo.getActivityName());
        cmsSuspensionSetting.setImageUrl(vo.getImageUrl());
        cmsSuspensionSetting.setRedirectUrl(vo.getRedirectUrl());
        cmsSuspensionSetting.setDeleteFlag(0);
        cmsSuspensionSettingService.insert(cmsSuspensionSetting);

        return response;
    }

    @Override
    public DubboResponse<CmsSuspensionSettingResponse> updateCmsSuspensionSetting(CmsSuspensionSettingRequest request) {
        DubboResponse<CmsSuspensionSettingResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        String id = request.getId();
        if (id != null && !id.equals("")) {
            CmsSuspensionSettingVo vo = request.getCmsSuspensionSettingVo();
            CmsSuspensionSetting cmsSuspensionSetting = new CmsSuspensionSetting();
            cmsSuspensionSetting.setId(id);
            cmsSuspensionSetting.setActivityName(vo.getActivityName());
            cmsSuspensionSetting.setImageUrl(vo.getImageUrl());
            cmsSuspensionSetting.setRedirectUrl(vo.getRedirectUrl());
            cmsSuspensionSettingService.update(cmsSuspensionSetting);
        } else {
            response.setError(Constants.System.PARAMS_INVALID);
            response.setStatus(Constants.System.FAIL);
        }


        return response;
    }

    @Override
    public DubboResponse<CmsSuspensionSettingResponse> deleteCmsSuspensionSetting(CmsSuspensionSettingRequest request) {
        DubboResponse<CmsSuspensionSettingResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        String id = request.getId();
        if(id != null && !id.equals("")){
            CmsSuspensionSetting cmsSuspensionSetting = new CmsSuspensionSetting();
            cmsSuspensionSetting.setId(id);
            cmsSuspensionSetting.setDeleteFlag(1);
            cmsSuspensionSettingService.update(cmsSuspensionSetting);
        } else {
            response.setError(Constants.System.PARAMS_INVALID);
            response.setStatus(Constants.System.FAIL);
        }

        return response;
    }
}
