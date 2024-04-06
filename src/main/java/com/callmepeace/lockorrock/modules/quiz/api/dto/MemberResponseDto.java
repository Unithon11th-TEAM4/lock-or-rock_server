package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberResponseDto {

    private Long memberId;
    private Boolean isDuplicatedNickname;

    public static MemberResponseDto fromEntityFound(MemberEntity memberEntity) {
        return new MemberResponseDto(memberEntity.getMemberId(), Boolean.TRUE);
    }

    public static MemberResponseDto fromNewEntity(MemberEntity memberEntity) {
        return new MemberResponseDto(memberEntity.getMemberId(), Boolean.FALSE);
    }
}
