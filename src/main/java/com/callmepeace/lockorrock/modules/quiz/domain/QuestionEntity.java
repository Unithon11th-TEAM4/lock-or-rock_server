package com.callmepeace.lockorrock.modules.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tb_question")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionEntity {


    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long questionId;

    private String content;

    @Column(name = "answer_id")
    private Long answerId = 0L;

    private String commentary;

    @Column(name = "is_proposed")
    private Boolean isProposed = Boolean.FALSE;

    @Column(name = "propose_member_id")
    private Long proposeMemberId;
}
