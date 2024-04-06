package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.MemberRequestDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.MemberResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseDto<MemberResponseDto> getOrRegisterMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {

        return ResponseDto.success(memberService.getOrRegisterMember(memberRequestDto));
    }
}
