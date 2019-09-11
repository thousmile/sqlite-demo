package com.ifsaid.sqlite.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: jackson Json 工具类
 * @author: Wang Chen Chen <932560435@qq.com>
 * @date: 2019/4/18 15:25
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Slf4j
public class JsonUtils {

    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * @description: 将对象转换成json字符串。
     * @param: [jsonData, beanType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static String objectToJson(Object data) {
        try {
            String result = MAPPER.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * @description: 将json结果集转化为对象
     * @param: [jsonData, beanType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


    /**
     * @description: 将json结果集转化为对象
     * @param: [jsonData, beanType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static <T> T byteToPojo(byte[] src, Class<T> beanType) {
        try {
            return MAPPER.readValue(src, beanType);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * @description: 将json数据转换成pojo对象list
     * @param: [jsonData, beanType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static <T> List<T> jsonToListPojo(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, beanType));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


    /**
     * @description: 将json数据转换成 Map
     * @param: [jsonData, keyType, valueType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static <K, V> Map<K, V> jsonToMap(String jsonData, Class<K> keyType, Class<V> valueType) {
        try {
            return MAPPER.readValue(jsonData, MAPPER.getTypeFactory().constructMapType(HashMap.class, keyType, valueType));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


    /**
     * @description: 将json数据转换成pojo对象list
     * @param: [jsonData, beanType]
     * @return: java.util.List<T>
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 15:26
     */
    public static <K, V> List<Map<K, V>> jsonToListMap(String jsonData, Class<K> keyType, Class<V> valueType) {
        try {
            return MAPPER.readValue(
                    jsonData,
                    MAPPER.getTypeFactory().constructCollectionType(List.class,
                            MAPPER.getTypeFactory().constructMapType(HashMap.class, keyType, valueType)
                    )
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }


}
