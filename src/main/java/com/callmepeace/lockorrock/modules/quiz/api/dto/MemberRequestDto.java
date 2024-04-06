package com.callmepeace.lockorrock.modules.quiz.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberRequestDto {

    @NotEmpty
    private String nickname;
}
