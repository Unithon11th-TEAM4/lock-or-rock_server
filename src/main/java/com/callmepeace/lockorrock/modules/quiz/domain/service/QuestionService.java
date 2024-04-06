package com.callmepeace.lockorrock.modules.quiz.domain.service;

import com.callmepeace.lockorrock.common.MemberPersonalityVerb;
import com.callmepeace.lockorrock.modules.quiz.api.dto.*;
import com.callmepeace.lockorrock.modules.quiz.domain.AnswerDetailEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.QuestionEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.AnswerDetailRepository;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.MemberRepository;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;
    private final AnswerDetailRepository answerDetailRepository;

    private static Long finalQuestionId = 4L;

    public List<QuestionResponseDto> getQuestions() {

        List<QuestionEntity> questionEntities = questionRepository.findAll();
        List<QuestionEntity> randomQuestionEntities = this.getRandomElement(questionEntities, 4);

        QuestionEntity finalQuestionEntity = questionRepository.findByQuestionId(finalQuestionId);
        randomQuestionEntities.add(finalQuestionEntity);

        List<QuestionResponseDto> questionDtos = randomQuestionEntities.stream().map(
                q -> QuestionResponseDto.fromEntityFound(q)).collect(Collectors.toList());

    return questionDtos;
    }

    public SubmitResponseDto setQuestions(QuestionRequestDto questionRequestDto) {

        MemberEntity memberEntity = memberRepository.findById(questionRequestDto.getMemberId()).get();
        List<AnswerRequestDto> answerRequestDtos = questionRequestDto.getAnswers();
        String nickname = memberEntity.getNickname();

        String memberPersonality1 = this.getAnswerContent(answerRequestDtos.get(0).getAnswerId());
        String memberPersonality2 = this.getAnswerContent(answerRequestDtos.get(1).getAnswerId());
        String memberPersonality3 = this.getAnswerContent(answerRequestDtos.get(2).getAnswerId());
        String memberPersonality4 = this.getAnswerContent(answerRequestDtos.get(3).getAnswerId());
        String memberPersonality5 = this.getAnswerContent(answerRequestDtos.get(4).getAnswerId());

        memberEntity = MemberEntity.builder()
                .memberPersonality1(memberPersonality1)
                .memberPersonality1(memberPersonality2)
                .memberPersonality1(memberPersonality3)
                .memberPersonality1(memberPersonality4)
                .memberPersonality1(memberPersonality5).build();

        MemberEntity savedMemberEntity = memberRepository.save(memberEntity);

        MemberPersonalityDto personality1 = new MemberPersonalityDto(
                savedMemberEntity.getMemberPersonality1(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality2 = new MemberPersonalityDto(
                savedMemberEntity.getMemberPersonality2(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality3 = new MemberPersonalityDto(
                savedMemberEntity.getMemberPersonality3(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality4 = new MemberPersonalityDto(
                savedMemberEntity.getMemberPersonality4(), MemberPersonalityVerb.AND.getText());
        MemberPersonalityDto personality5 = new MemberPersonalityDto(
                savedMemberEntity.getMemberPersonality5(), MemberPersonalityVerb.END.getText());

        List<MemberPersonalityDto> personalityDtoList = new ArrayList<>(
                Arrays.asList(personality1, personality2, personality3, personality4, personality5)
        );

        return new SubmitResponseDto(
                nickname,
                personalityDtoList
        );

    }

    public String getAnswerContent(Long answerId) {
        AnswerDetailEntity answerDetailEntity = answerDetailRepository.findById(answerId).get();
        return answerDetailEntity.getContent();
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
