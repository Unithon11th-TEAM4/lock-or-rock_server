package com.callmepeace.lockorrock.common;

import lombok.Getter;

@Getter
public class ResponseDto<T> {

    private int code;
    private String message;
    private T data;

    public ResponseDto(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static<T> ResponseDto<T> success(T data) {
        ResponseCode ok = ResponseCode.OK;
        return new ResponseDto<>(ok.getCode(), ok.getMessage(), data);
    }

    public static <T> ResponseDto<T> failure(ResponseCode code, T data) {
        return new ResponseDto<>(code.getCode(), code.getMessage(), data);
    }
}
