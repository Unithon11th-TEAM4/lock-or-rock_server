package com.callmepeace.lockorrock.modules.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_proposed_answer_detail")
@NoArgsConstructor
@AllArgsConstructor
public class ProposedAnswerDetailEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private ProposedQuestionEntity proposedQuestionEntity;

    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long answerId;

    private String content;

}
