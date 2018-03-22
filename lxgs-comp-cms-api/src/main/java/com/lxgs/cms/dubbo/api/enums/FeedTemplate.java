package com.lxgs.cms.dubbo.api.enums;

import java.util.Arrays;

/**
 * *****************************************************************************
 * <p>
 * 功能名           ：com.lxgs.cms.dubbo.api.enums
 * 系统名           ：Feed模板枚举
 * <p>
 * *****************************************************************************
 * Modification History
 * <p>
 * Date        Name                    Reason for Change
 * ----------  ----------------------  -----------------------------------------
 * 2017/8/22    wenzhou.xu              Created
 */
public enum FeedTemplate implements IEnum{
    SMALL_ONE_PIC_TXT(101, "小图文信息式样"),
    SMALL_MULTI_PIC_TXT(102, "多图文信息式样"),
    BIG_PIC_TXT(103, "大图文信息式样"),
    SMALL_VIDEO_TXT(104, "小视频及文字信息样式"),
    BIG_VIDEO_TXT(105, "大视频及文字信息样式"),
    VIDEO_LIVE(114, "Feed视频直接播放样式"),
    ;

    private Integer code;
    private String desc;

    FeedTemplate(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static FeedTemplate getInstance(Integer code){
        return Arrays.stream(values()).filter(obj -> obj.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
