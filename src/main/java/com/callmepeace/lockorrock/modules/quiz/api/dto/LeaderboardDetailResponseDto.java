package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.common.MemberPersonalityVerb;
import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LeaderboardDetailResponseDto {

    private Long memberId;
    private List<MemberPersonalityDto> memberPersonality;
    private Long likeCount;

    public static LeaderboardDetailResponseDto fromEntity(MemberEntity memberEntity) {

        MemberPersonalityDto personality1 = new MemberPersonalityDto(
            memberEntity.getMemberPersonality1(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality2 = new MemberPersonalityDto(
            memberEntity.getMemberPersonality2(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality3 = new MemberPersonalityDto(
            memberEntity.getMemberPersonality3(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality4 = new MemberPersonalityDto(
            memberEntity.getMemberPersonality4(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality5 = new MemberPersonalityDto(
            memberEntity.getMemberPersonality5(), MemberPersonalityVerb.END.getText());

        List<MemberPersonalityDto> personalityDtoList = new ArrayList<>(
            Arrays.asList(personality1, personality2, personality3, personality4, personality5)
        );

        return new LeaderboardDetailResponseDto(
            memberEntity.getMemberId(),
            personalityDtoList,
            memberEntity.getLikeCount()
        );
    }

}
