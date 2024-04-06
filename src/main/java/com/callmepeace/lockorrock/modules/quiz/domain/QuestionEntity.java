package com.callmepeace.lockorrock.modules.quiz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "tb_question")
@NoArgsConstructor
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private List<AnswerDetailEntity> answerDetailEntity;
}
