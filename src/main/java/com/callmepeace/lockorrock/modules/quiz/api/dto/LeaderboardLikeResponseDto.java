package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LeaderboardLikeResponseDto {

    private Long likeCount;

    public static LeaderboardLikeResponseDto fromEntity(MemberEntity memberEntity) {
        return new LeaderboardLikeResponseDto(memberEntity.getLikeCount());
    }
}
