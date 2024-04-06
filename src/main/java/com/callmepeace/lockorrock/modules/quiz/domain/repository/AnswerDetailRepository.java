package com.callmepeace.lockorrock.modules.quiz.domain.repository;

import com.callmepeace.lockorrock.modules.quiz.domain.AnswerDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerDetailRepository extends JpaRepository<AnswerDetailEntity, Long> {

//    Optional<AnswerDetailEntity> findByQuestionID(Long questionId);
}
