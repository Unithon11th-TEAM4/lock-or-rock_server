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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tb_answer_detail")
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDetailEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long answerId;

    private String content;

    private String url;

    private String personality;

}
