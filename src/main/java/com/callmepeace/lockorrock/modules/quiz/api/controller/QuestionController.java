package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.QuestionRequestDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.QuestionResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.SubmitResponseDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseDto<List<QuestionResponseDto>> getQuestions() {

        return ResponseDto.success(questionService.getQuestions());
    }

    @PostMapping("/questions")
    public ResponseDto<SubmitResponseDto> setQuestions(@RequestBody @Valid QuestionRequestDto questionRequestDto) {

        return ResponseDto.success(questionService.setQuestions(questionRequestDto));
    }

}
