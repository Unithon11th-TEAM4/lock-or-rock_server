package com.callmepeace.lockorrock.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    OK(0, "OK"),
    BAD_REQUEST(400, "BAD REQUEST"),
    UNSUPPORTED_MEDIA_TYPE(415, "UNSUPPORTED MEDIA TYPE"),
    METHOD_NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR")
    ;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;
}
