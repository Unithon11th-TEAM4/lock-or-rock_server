package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.ProposeQuestionRequestDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.ProposeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProposeController {

    private final ProposeService proposeService;

    @PostMapping("/proposed-question")
    public ResponseDto proposeQuestion(@RequestBody @Valid ProposeQuestionRequestDto proposeQuestionRequestDto) {

        proposeService.proposeQuestion(proposeQuestionRequestDto);
        return ResponseDto.success(null);
    }
}
