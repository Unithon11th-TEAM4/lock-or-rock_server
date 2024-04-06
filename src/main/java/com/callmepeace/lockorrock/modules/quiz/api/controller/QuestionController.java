package com.callmepeace.lockorrock.modules.quiz.api.controller;

import com.callmepeace.lockorrock.common.ResponseDto;
import com.callmepeace.lockorrock.modules.quiz.api.dto.QuestionDto;
import com.callmepeace.lockorrock.modules.quiz.domain.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseDto<List<QuestionDto>> getQuestions() {

        return ResponseDto.success(questionService.getQuestions());
    }

}
