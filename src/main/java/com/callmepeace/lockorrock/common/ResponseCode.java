package com.callmepeace.lockorrock.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    OK(0, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    UNSUPPORTED_MEDIA_TYPE(415, "UNSUPPORTED MEDIA TYPE"),
    NOT_FOUND(404, "NOT FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR"),
    MEMBER_NOT_FOUND(1000, "MEMBER NOT FOUND"),
    MEMBER_NOT_SUBMIT_ANSWER(2000, "MEMBER NOT SUBMIT ANSWER")
    ;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
