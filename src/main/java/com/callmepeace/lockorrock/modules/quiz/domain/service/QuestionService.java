package com.callmepeace.lockorrock.modules.quiz.domain.service;

import com.callmepeace.lockorrock.modules.quiz.api.dto.AnswerDetailDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.QuestionDto;
import com.callmepeace.lockorrock.modules.quiz.domain.QuestionEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private static Long finalQuestionId = 4L;

    public List<QuestionDto> getQuestions() {

        List<QuestionEntity> questionEntities = questionRepository.findAll();
        List<QuestionEntity> randomQuestionEntities = this.getRandomElement(questionEntities, 4);

        QuestionEntity finalQuestionEntity = questionRepository.findByQuestionId(finalQuestionId);
        randomQuestionEntities.add(finalQuestionEntity);

        List<QuestionDto> questionDtos = randomQuestionEntities.stream().map(
                q -> QuestionDto.fromEntityFound(q)).collect(Collectors.toList());

    return questionDtos;
    }

    public List<QuestionEntity> getRandomElement(List<QuestionEntity> questionEntity, int totalItems)
    {
        Random rand = new Random();

        List<QuestionEntity> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            int randomIndex = rand.nextInt(questionEntity.size());
            newList.add(questionEntity.get(randomIndex));
            questionEntity.remove(randomIndex);
        }
        return newList;
    }
}
