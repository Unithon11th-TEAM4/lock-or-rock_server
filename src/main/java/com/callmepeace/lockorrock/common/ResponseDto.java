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
        return new ResponseDto<>(0, "OK", data);
    }

    public static <T> ResponseDto<T> failure(T data) {
        return new ResponseDto<>(10, "FAILURE", data);
    }
}
