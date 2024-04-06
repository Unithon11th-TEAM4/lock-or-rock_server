package com.callmepeace.lockorrock.modules.quiz.domain.repository;

import com.callmepeace.lockorrock.modules.quiz.domain.ProposedAnswerDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposeAnswerRepository extends JpaRepository<ProposedAnswerDetailEntity, Long> {

}
