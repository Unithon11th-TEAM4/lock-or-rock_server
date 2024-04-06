package com.callmepeace.lockorrock.modules.quiz.domain.repository;

import com.callmepeace.lockorrock.modules.quiz.domain.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    QuestionEntity findByQuestionId(Long finalQuestionId);
}
