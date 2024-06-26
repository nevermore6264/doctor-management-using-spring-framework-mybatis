package com.daykemit.doctor.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response class
 *
 * @author HieuTT
 * @version 1.0
 * @since 06/01/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Response {
    private String type;
    private String code;
    private String message;
    private Object data;

    public Response(String type) {
        this.type = type;
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(String type, String code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public Response withData(Object data) {
        this.data = data;
        return this;
    }

    public static Response success(String code) {
        return new Response(Constants.RESPONSE_CODE.SUCCESS, code);
    }

    public static Response success(String code, String message) {
        return new Response(Constants.RESPONSE_TYPE.SUCCESS, code, message, null);
    }

    public static Response success(String code, String message, Object data) {
        return new Response(Constants.RESPONSE_TYPE.SUCCESS, code, message, data);
    }

    public static Response error(String data) {
        return new Response(Constants.RESPONSE_TYPE.ERROR, data);
    }

    public static Response error(String code, String message) {
        return new Response(Constants.RESPONSE_TYPE.ERROR, code, message);
    }

    public static Response warning(String code, String message) {
        return new Response(Constants.RESPONSE_TYPE.WARNING, code, message);
    }

    public static Response invalidPermission() {
        return new Response(Constants.RESPONSE_CODE.ERROR, "invalidPermission");
    }

    public static Response confirm(String code, String callback, Object data) {
        return new Response(Constants.RESPONSE_TYPE.CONFIRM, code, callback, data);
    }

    public static Response confirm(String code, String callback) {
        return new Response(Constants.RESPONSE_TYPE.CONFIRM, code, callback, null);
    }

    public static Response errorLogin(String code) {
        return new Response(Constants.RESPONSE_CODE.ERROR_LOGIN, code);
    }

    public static Response custom(String code, String message) {
        return new Response(Constants.RESPONSE_TYPE.ERROR, code, message, null);
    }
}
