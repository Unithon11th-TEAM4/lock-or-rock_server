package com.callmepeace.lockorrock.modules.quiz.domain.service;

import com.callmepeace.lockorrock.global.MemberNotFoundException;
import com.callmepeace.lockorrock.modules.quiz.api.dto.ProposeQuestionRequestDto;
import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.ProposedAnswerDetailEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.ProposedQuestionEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.MemberRepository;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.ProposeAnswerRepository;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.ProposeQuestionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProposeService {

    private final MemberRepository memberRepository;
    private final ProposeQuestionRepository proposeQuestionRepository;
    private final ProposeAnswerRepository proposeAnswerRepository;

    @Transactional
    public void proposeQuestion(ProposeQuestionRequestDto proposeQuestionRequestDto) {

        MemberEntity memberEntity = memberRepository.findById(proposeQuestionRequestDto.getMemberId())
            .orElseThrow(MemberNotFoundException::new);

        ProposedQuestionEntity proposedQuestionEntity = ProposedQuestionEntity.builder()
            .memberEntity(memberEntity)
            .content(proposeQuestionRequestDto.getQuestionContent())
            .build();
        ProposedQuestionEntity savedProposeQuestionEntity = proposeQuestionRepository.save(proposedQuestionEntity);

        List<String> questionAnswers = proposeQuestionRequestDto.getQuestionAnswers();
        List<ProposedAnswerDetailEntity> proposedAnswerEntityList = questionAnswers.stream()
            .map(answer -> ProposedAnswerDetailEntity.builder()
                .proposedQuestionEntity(savedProposeQuestionEntity)
                .content(answer)
                .build()
            )
            .toList();

        proposeAnswerRepository.saveAll(proposedAnswerEntityList);
    }

}
