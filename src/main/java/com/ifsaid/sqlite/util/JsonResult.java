package com.ifsaid.sqlite.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: RESTful API 统一返回实体类
 * @author: Wang Chen Chen <932560435@qq.com>
 * @date: 2019/4/18 12:02
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Getter
@Setter
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 1456468469856161L;

    /**
     * 返回状态码
     */
    private Integer status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 时间搓
     */
    private Long timestamp;

    private JsonResult() {
    }

    /**
     * @description: 自定义返回状态码
     * @date: 2019/5/15 10:21
     */
    private static <T> JsonResult result(int status, String message, T data) {
        JsonResult result = new JsonResult();
        result.status = status;
        result.message = message;
        result.data = data;
        result.timestamp = System.currentTimeMillis();
        return result;
    }

    /**
     * @description: 自定义返回状态码
     * @date: 2019/5/15 10:21
     */
    private static <T> JsonResult result(HttpStatus httpStatus, T data) {
        return result(httpStatus.status, httpStatus.value, data);
    }

    /**
     * @description: 自定义返回状态码 [不建议使用，建议扩展方法]
     * @date: 2019/5/15 10:21
     */
    public static <T> JsonResult result(int status, String message) {
        return result(status, message, null);
    }



    /**
     * @description: 操作成功
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult success() {
        return success(HttpStatus.OK.value, null);
    }

    public static <T> JsonResult success(String message) {
        return success(message, null);
    }

    public static <T> JsonResult success(T data) {
        return success(HttpStatus.OK.value, data);
    }

    public static <T> JsonResult success(String message, T data) {
        return result(HttpStatus.OK.status, message, data);
    }



    /**
     * @description: 操作失败
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult fail(String message) {
        return fail(message, null);
    }

    public static <T> JsonResult fail(T data) {
        return fail(HttpStatus.FAIL.value, data);
    }

    public static <T> JsonResult fail(String message, T data) {
        return result(HttpStatus.FAIL.status, message, data);
    }


    /**
     * @description: 未授权
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult error401() {
        return result(HttpStatus.UNAUTHORIZED.status, HttpStatus.UNAUTHORIZED.value, null);
    }


    /**
     * @description: 未授权
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult error415() {
        return result(HttpStatus.UNSUPPORTED_MEDIA_TYPE.status, HttpStatus.UNSUPPORTED_MEDIA_TYPE.value, null);
    }


    /**
     * @description: 404 未找到
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult error404() {
        return result(HttpStatus.NOT_FOUND.status, HttpStatus.NOT_FOUND.value, null);
    }


    /**
     * @description: 服务器内部错误
     * @date: 2019/4/18 12:04
     */
    public static <T> JsonResult error500() {
        return result(HttpStatus.INTERNAL_SERVER_ERROR.status, HttpStatus.INTERNAL_SERVER_ERROR.value, null);
    }


    /**
     * @description: restful api 返回状态码。不够的时候自己扩展
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/5/15 11:33
     */
    public enum HttpStatus {

        /**
         * @description: 正常 返回代码
         * @date: 2019/5/15 11:06
         */
        OK(200, "Ok"),

        /**
         * @description: 错误 返回代码
         * @date: 2019/5/15 11:06
         */
        FAIL(0, "Fail"),

        /**
         * @description: 404 为找到
         * @date: 2019/5/15 11:06
         */
        NOT_FOUND(404, "Not Found"),

        /**
         * @description: 未经授权
         * @date: 2019/8/21 16:55
         */
        UNAUTHORIZED(401, "Unauthorized"),

        /**
         * @description: 不支持的媒体类型
         * @date: 2019/8/21 16:55
         */
        UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),

        /**
         * @description: 服务器内部错误 返回代码
         * @date: 2019/5/15 11:06
         */
        INTERNAL_SERVER_ERROR(500, "Internal Server Error");

        private int status;

        private String value;

        HttpStatus(int status, String value) {
            this.status = status;
            this.value = value;
        }

    }

}