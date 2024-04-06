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
@Table(name = "tb_member")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String nickname;

    @Column(name = "member_personality")
    private String memberPersonality;

    @Column(name = "like_count")
    private Long likeCount;
}
