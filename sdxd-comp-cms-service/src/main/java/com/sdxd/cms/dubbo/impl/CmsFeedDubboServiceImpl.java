package com.sdxd.cms.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.sdxd.cms.dubbo.api.CmcFeedDubboService;
import com.sdxd.cms.dubbo.api.pojo.CmsFeedVo;
import com.sdxd.cms.dubbo.api.request.CmsFeedRequest;
import com.sdxd.cms.dubbo.api.response.CmsFeedResponse;
import com.sdxd.cms.entity.CmsFeed;
import com.sdxd.cms.service.CmsFeedService;
import com.sdxd.framework.constant.Constants;
import com.sdxd.framework.dto.PaginationSupport;
import com.sdxd.framework.dubbo.DubboResponse;
import com.sdxd.framework.dubbo.PageRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.sdxd.cms.dubbo.impl
 * 系统名           ：
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/18    wenzhou.xu              Created
 */
@Service(interfaceName = "com.sdxd.cms.dubbo.api.CmcFeedDubboService", validation = "true", version = "1.0.0", timeout = 30000)
public class CmsFeedDubboServiceImpl implements CmcFeedDubboService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsFeedDubboServiceImpl.class);

    @Resource
    private CmsFeedService cmsFeedService;

    /**
     * 查询Feed素材列表
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<CmsFeedResponse> searchCmsFeedList(PageRequest request) {
        LOGGER.debug("searchCmsFeedList,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsFeedResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        try {
            CmsFeed cmsFeed = new CmsFeed();
            cmsFeed.setDeleteFlag(0);
            //查询总数
            Integer count = cmsFeedService.count(cmsFeed);
            //分页查询
            List<CmsFeed> cmsFeedList = cmsFeedService.searchPage(request.getCurrentPage(), request.getPageSize());
            //重新封装
            List<CmsFeedVo> voList = cmsFeedList.stream().map(this::buildCmsFeedVo).collect(Collectors.toList());
            //构建Page
            PaginationSupport<CmsFeedVo> page = new PaginationSupport<>(voList, count, request.getPageSize(), request.getStartItem());
            CmsFeedResponse cmsFeedResponse = new CmsFeedResponse();
            cmsFeedResponse.setRequestId(request.getRequestId());
            cmsFeedResponse.setPage(page);

            response.setData(cmsFeedResponse);
        }
        catch (Exception e){
            LOGGER.error("searchCmsFeedList", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    /**
     * 查询Feed素材明细
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<CmsFeedResponse> queryCmsFeed(CmsFeedRequest request) {
        LOGGER.debug("queryCmsFeed,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsFeedResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        try {
            CmsFeed cmsFeed = cmsFeedService.getById(request.getId());

            CmsFeedResponse cmsFeedResponse = new CmsFeedResponse();
            cmsFeedResponse.setRequestId(request.getRequestId());
            cmsFeedResponse.setCmsFeedVo(buildCmsFeedVo(cmsFeed));

            response.setData(cmsFeedResponse);
        }
        catch (Exception e){
            LOGGER.error("queryCmsFeed", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    /**
     * 新增/更新Feed素材
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<CmsFeedResponse> saveCmsFeed(CmsFeedRequest request) {
        LOGGER.debug("updateCmsFeed,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsFeedResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        try {
            CmsFeed cmsFeed = buildCmsFeed(request.getCmsFeedVo());
            saveCmsFeed(cmsFeed);

            CmsFeedResponse cmsFeedResponse = new CmsFeedResponse();
            cmsFeedResponse.setRequestId(request.getRequestId());
            cmsFeedResponse.setSuccess(true);

            response.setData(cmsFeedResponse);
        }
        catch (Exception e){
            LOGGER.error("updateCmsFeed", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    /**
     * 删除Feed素材
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<CmsFeedResponse> deleteCmsFeed(CmsFeedRequest request) {
        LOGGER.debug("deleteCmsFeed,requestParam:{}", JSONObject.toJSONString(request));
        DubboResponse<CmsFeedResponse> response = new DubboResponse<>();
        response.setError(Constants.System.SERVER_SUCCESS);
        response.setStatus(Constants.System.OK);

        try {
            CmsFeed cmsFeed = cmsFeedService.getById(request.getId());
            cmsFeed.setDeleteFlag(1);//删除
            cmsFeedService.update(cmsFeed);

            CmsFeedResponse cmsFeedResponse = new CmsFeedResponse();
            cmsFeedResponse.setRequestId(request.getRequestId());
            cmsFeedResponse.setSuccess(true);

            response.setData(cmsFeedResponse);
        }
        catch (Exception e){
            LOGGER.error("deleteCmsFeed", e);
            response.setError(Constants.System.SYSTEM_ERROR_CODE);
            response.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        }

        return response;
    }

    private CmsFeedVo buildCmsFeedVo(CmsFeed feed) {
        CmsFeedVo vo = new CmsFeedVo();
        vo.setId(feed.getId());
        vo.setTitle(feed.getTitle());
        vo.setTag(feed.getTag());
        vo.setFeedUrl(feed.getFeedUrl());
        vo.setFrom(feed.getFrom());
        vo.setComment(feed.getIsCommont());
        vo.setDisplay(feed.getIsDisplay());
        List<String> imgList = new ArrayList<>();
        imgList.add(feed.getImage1Url());
        imgList.add(feed.getImage2Url());
        imgList.add(feed.getImage3Url());
        vo.setImgList(imgList);
        return vo;
    }

    private CmsFeed buildCmsFeed(CmsFeedVo vo){
        CmsFeed cmsFeed = new CmsFeed();
        cmsFeed.setId(vo.getId());

        cmsFeed.setTitle(vo.getTitle());
        cmsFeed.setTag(vo.getTag());
        cmsFeed.setFeedUrl(vo.getFeedUrl());
        cmsFeed.setFrom(vo.getFrom());
        cmsFeed.setIsCommont(vo.getComment());
        cmsFeed.setIsDisplay(vo.getDisplay());
        cmsFeed.setImage1Url(vo.getImgList().get(0));
        cmsFeed.setImage2Url(vo.getImgList().get(1));
        cmsFeed.setImage3Url(vo.getImgList().get(2));

        return cmsFeed;
    }

    private void saveCmsFeed(CmsFeed cmsFeed){
        //如果此Feed显示，则其他所有的素材置为不显示
        if(cmsFeed.getIsDisplay() == 1){
            CmsFeed params = new CmsFeed();
            params.setIsDisplay(1);//显示
            params.setDeleteFlag(0);//未删除
            List<CmsFeed> cmsFeedList = cmsFeedService.getByObj(params);

            cmsFeedList.stream().filter(value -> !value.getId().equals(cmsFeed.getId())).forEach(value -> value.setIsDisplay(0));//过滤自己，其他置为不显示
            cmsFeedService.update(cmsFeedList);//批量更新
        }

        //根据是否包含主键确认调用方法
        if(StringUtils.isBlank(cmsFeed.getId()))
            cmsFeedService.insert(cmsFeed);
        else
            cmsFeedService.update(cmsFeed);

    }
}
