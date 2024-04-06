package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardListResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
