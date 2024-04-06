package com.callmepeace.lockorrock.global;

import com.callmepeace.lockorrock.common.ResponseCode;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends BusinessException {

    private ResponseCode errorCode;

    public MemberNotFoundException() {
        super(ResponseCode.MEMBER_NOT_FOUND);
        this.errorCode = ResponseCode.MEMBER_NOT_FOUND;
    }
}
