package com.callmepeace.lockorrock.modules.quiz.domain.repository;

import com.callmepeace.lockorrock.modules.quiz.domain.ProposedQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposeQuestionRepository extends JpaRepository<ProposedQuestionEntity, Long> {

}