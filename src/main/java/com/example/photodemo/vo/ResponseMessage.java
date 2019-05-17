package com.example.photodemo.vo;

import com.example.photodemo.bc.ResponseStatus;

/**
 * 返回的信息
 * @author zmt
 * @date 2019-05-13 14:12
 */
public class ResponseMessage {
    /**
     * 状态码
     */
    private int code;
    /**
     * msg信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;
    /**
     *
     */
    private boolean more;

    public ResponseMessage(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage() {
        this.code = ResponseStatus.SUCCESS.getCode();
        this.message = ResponseStatus.SUCCESS.getStandardMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static ResponseMessage ofMessage(int code, String message) {
        return new ResponseMessage(code, message, null);
    }

    public static ResponseMessage ofSuccess(Object data) {
        return new ResponseMessage(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getStandardMessage(), data);
    }

    public static ResponseMessage ofStatus(ResponseStatus responseStatus) {
        return new ResponseMessage(responseStatus.getCode(), responseStatus.getStandardMessage(), null);
    }
}
