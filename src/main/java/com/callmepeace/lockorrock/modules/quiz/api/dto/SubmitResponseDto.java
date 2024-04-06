package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.QuestionEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SubmitResponseDto {

    private String nickname;
    private List<MemberPersonalityDto> member_personality;

}
