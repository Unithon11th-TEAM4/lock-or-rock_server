package com.callmepeace.lockorrock.modules.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
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

    @Column(name = "member_personality1")
    private String memberPersonality1;

    @Column(name = "member_personality2")
    private String memberPersonality2;

    @Column(name = "member_personality3")
    private String memberPersonality3;

    @Column(name = "member_personality4")
    private String memberPersonality4;

    @Column(name = "member_personality5")
    private String memberPersonality5;

    @Builder.Default
    @Column(name = "like_count")
    private Long likeCount = 0L;

    public void addLikeCount() {
        this.likeCount += 1;
    }

    public void resetLikeCount() {
        this.likeCount = 0L;
    }

    public Boolean isNotSubmitted() {

        return Objects.isNull(this.memberPersonality1)
            || Objects.isNull(this.memberPersonality2)
            || Objects.isNull(this.memberPersonality3)
            || Objects.isNull(this.memberPersonality4)
            || Objects.isNull(this.memberPersonality5);
    }
}
