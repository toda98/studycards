package com.tommydang.studycards.controller;

import com.tommydang.studycards.dto.StudyModuleResponse;
import com.tommydang.studycards.entity.StudyModule;
import com.tommydang.studycards.mapper.StudyModuleMapper;
import com.tommydang.studycards.service.StudyModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/study-modules")
public class StudyModuleController {
    private final StudyModuleService studyModuleService;
    private final StudyModuleMapper studyModuleMapper;

    public StudyModuleController(
            StudyModuleService studyModuleService,
            StudyModuleMapper studyModuleMapper
    ) {
        this.studyModuleService = studyModuleService;
        this.studyModuleMapper = studyModuleMapper;
    }

    @GetMapping
    public ResponseEntity<Set<StudyModuleResponse>> loadAllStudyModules() {
        Set<StudyModule> studyModuleSet = studyModuleService.loadAllStudyModules();
        Set<StudyModuleResponse> studyModuleResponseSet = new HashSet<>();
        for (StudyModule studyModule : studyModuleSet) {
            studyModuleResponseSet.add(studyModuleMapper.toResponse(studyModule));
        }
        return ResponseEntity.ok(studyModuleResponseSet);
    }
}
