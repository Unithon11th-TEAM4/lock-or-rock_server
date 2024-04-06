package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.common.MemberPersonalityVerb;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberPersonalityDto {

    private String content;
    private String verb;

}
