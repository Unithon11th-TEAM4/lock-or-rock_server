package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnswerRequestDto {

    @NotEmpty
    private Long questionId;

    @NotEmpty
    private Long answerId;
}
