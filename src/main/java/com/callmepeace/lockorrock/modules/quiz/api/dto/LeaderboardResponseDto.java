package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LeaderboardResponseDto {

    private int rankNo;
    private Long memberId;
    private String nickname;
    private Long likeCount;

    public static LeaderboardResponseDto fromEntityAndRankNo(int rankNo, MemberEntity memberEntity) {

        return new LeaderboardResponseDto(rankNo,
                                          memberEntity.getMemberId(),
                                          memberEntity.getNickname(),
                                          memberEntity.getLikeCount()
        );
    }
}
