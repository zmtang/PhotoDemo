package com.example.photodemo.bc;

/**
 * web请求的返回状态
 *
 * @author zmt
 * @date 2019-05-13 14:54
 */
public enum ResponseStatus {
    SUCCESS(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
    NOT_VALID_PARAM(40005, "Not valid Params"),
    NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
    NOT_LOGIN(50000, "Not Login");

    private int code;
    private String standardMessage;

    ResponseStatus(int code, String standardMessage) {
        this.code = code;
        this.standardMessage = standardMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStandardMessage() {
        return standardMessage;
    }

    public void setStandardMessage(String standardMessage) {
        this.standardMessage = standardMessage;
    }
}
