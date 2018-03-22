package com.lxgs.cms.utils;

import com.sdxd.common.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: chenliufei
 * Date: 2017-04-21
 * Time: 下午6:27
 */

@Slf4j
public class TransformUtil {
    public static void copy(Object dest, Object ori) {
        try {
            BeanUtils.copyProperties(dest, ori);
        }
        catch (Exception ex) {
            log.error("bean copy exception: {}", ex);
        }
    }

    public static <T> List<T> toList(List srcList, Class<T> clazz) {
        if (srcList != null && srcList.size() > 0) {
            Stream<T> tStream = srcList.stream().map(o -> {
                T obj = org.springframework.beans.BeanUtils.instantiate(clazz);
                copy(obj, o);
                return obj;
            });

            return tStream.collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

}
