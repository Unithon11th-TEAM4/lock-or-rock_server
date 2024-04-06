package com.callmepeace.lockorrock.modules.quiz.api.dto;

import com.callmepeace.lockorrock.modules.quiz.domain.AnswerDetailEntity;
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
public class QuestionDto {

    private Long questionId;
    private String content;
    private Long answerId;
    private String commentary;
    private List<AnswerDetailDto> answers;

    public static QuestionDto fromEntityFound(QuestionEntity questionEntity) {
        return new QuestionDto(questionEntity.getQuestionId(),
                                        questionEntity.getContent(),
                                        questionEntity.getAnswerId(),
                                        questionEntity.getCommentary(),
                                        questionEntity.getAnswerDetailEntity().stream().map(
                                                a -> AnswerDetailDto.fromEntityFound(a)
                                        ).collect(Collectors.toList()));

    }

}
