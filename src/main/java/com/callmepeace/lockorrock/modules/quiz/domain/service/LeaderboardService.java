package com.callmepeace.lockorrock.modules.quiz.domain.service;

import com.callmepeace.lockorrock.common.ResponseCode;
import com.callmepeace.lockorrock.global.BusinessException;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardListResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.LeaderboardResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.MemberEntity;
import com.callmepeace.lockorrock.modules.quiz.domain.repository.MemberRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaderboardService {

    private final MemberRepository memberRepository;

    public LeaderboardListResponseDto getLeaderboards(Long memberId) {

        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberEntity> sortedMemberList = memberEntityList.stream()
            .sorted(
                Comparator.comparingLong(MemberEntity::getLikeCount).reversed()
            )
            .toList();
        int myIndex = IntStream.range(0, sortedMemberList.size())
            .filter(i -> sortedMemberList.get(i).getMemberId().equals(memberId))
            .findFirst()
            .orElse(-1);
        List<MemberEntity> leaderboards = sortedMemberList.stream().limit(10).toList();

        if (myIndex == -1) {
            throw new BusinessException(ResponseCode.MEMBER_NOT_FOUND);
        }
        MemberEntity myMemberEntity = sortedMemberList.get(myIndex);

        ArrayList<LeaderboardResponseDto> leaderboardResponseDtoList = new ArrayList<>();
        int myRankNo = myIndex < 10 ? myIndex + 1 : 0;
        leaderboardResponseDtoList.add(
            LeaderboardResponseDto.fromEntityAndRankNo(myRankNo, myMemberEntity)
        );
        List<LeaderboardResponseDto> responseList = IntStream.range(0, leaderboards.size())
            .mapToObj(i -> LeaderboardResponseDto.fromEntityAndRankNo(i + 1, leaderboards.get(i)))
            .toList();
        leaderboardResponseDtoList.addAll(responseList);
        return new LeaderboardListResponseDto(leaderboardResponseDtoList);
    }

}
