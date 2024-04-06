package com.callmepeace.lockorrock.modules.quiz.domain.repository;

import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByNickname(String nickname);


}
