package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.AnswerDetailEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AnswerDetailDto {

    private Long answerId;
    private String content;
    private String url;
    private String personality;

    public static AnswerDetailDto fromEntityFound(AnswerDetailEntity answerDetailEntity) {
        return new AnswerDetailDto(answerDetailEntity.getAnswerId(),
                answerDetailEntity.getContent(),
                answerDetailEntity.getUrl(),
                answerDetailEntity.getPersonality());
    }

}
