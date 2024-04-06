package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardDetailResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardLikeRequestDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardLikeResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardListResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.LeaderboardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @GetMapping("/leaderboards")
    public ResponseDto<LeaderboardListResponseDto> getLeaderboards(
        @RequestParam(name = "member_id") Long memberId
    ) {

        return ResponseDto.success(leaderboardService.getLeaderboards(memberId));
    }

    @PostMapping("/leaderboard/like")
    public ResponseDto<LeaderboardLikeResponseDto> sendLikeLeaderboard(@RequestBody @Valid LeaderboardLikeRequestDto leaderboardLikeRequestDto) {

        return ResponseDto.success(leaderboardService.sendLikeLeaderboard(leaderboardLikeRequestDto.getMemberId()));
    }

    @GetMapping("/leaderboard")
    public ResponseDto<LeaderboardDetailResponseDto> getLeaderboardDetail(
        @RequestParam(name = "member_id") Long memberId
    ) {

        return ResponseDto.success(leaderboardService.getLeaderboardDetail(memberId));
    }
}
