package com.callmepeace.lockorrock.modules.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "tb_member")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String nickname;

    @Column(name = "member_personality")
    private String memberPersonality;

    @Builder.Default
    @Column(name = "like_count")
    private Long likeCount = 0L;
}
