package com.callmepeace.lockorrock.global;

import com.callmepeace.lockorrock.common.ResponseCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ResponseCode errorCode;

    public BusinessException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
