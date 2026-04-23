package com.tommydang.studycards.controller;

import com.tommydang.studycards.dto.FieldOfStudyResponse;
import com.tommydang.studycards.entity.FieldOfStudy;
import com.tommydang.studycards.mapper.FieldOfStudyMapper;
import com.tommydang.studycards.service.FieldOfStudyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/fields-of-study")
public class FieldOfStudyController {
    private final FieldOfStudyService fieldOfStudyService;
    private final FieldOfStudyMapper fieldOfStudyMapper;

    public FieldOfStudyController(
            FieldOfStudyService fieldOfStudyService,
            FieldOfStudyMapper fieldOfStudyMapper
    ) {
        this.fieldOfStudyService = fieldOfStudyService;
        this.fieldOfStudyMapper = fieldOfStudyMapper;
    }

    @GetMapping
    public ResponseEntity<Set<FieldOfStudyResponse>> loadAllFieldOfStudies() {
        Set<FieldOfStudy> fieldOfStudySet = fieldOfStudyService.loadAllFieldOfStudies();
        Set<FieldOfStudyResponse> fieldOfStudyResponseSet = new HashSet<>();
        for (FieldOfStudy fieldOfStudy : fieldOfStudySet) {
            fieldOfStudyResponseSet.add(fieldOfStudyMapper.toResponse(fieldOfStudy));
        }
        return ResponseEntity.ok(fieldOfStudyResponseSet);
    }
}
