package com.callmepeace.lockorrock.modules.quiz.domain.service;

import com.callmepeace.lockorrock.modules.quiz.api.dto.MemberRequestDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.MemberResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto getOrRegisterMember(MemberRequestDto memberRequestDto) {

        String nickname = memberRequestDto.getNickname();
        Optional<MemberEntity> memberEntity = memberRepository.findByNickname(nickname);

        if (memberEntity.isPresent()) {
            return MemberResponseDto.fromEntityFound(memberEntity.get());
        }

        MemberEntity newMemberEntity = MemberEntity.builder().nickname(nickname).build();
        MemberEntity savedMemberEntity = memberRepository.save(newMemberEntity);
        return MemberResponseDto.fromNewEntity(savedMemberEntity);
    }
}
