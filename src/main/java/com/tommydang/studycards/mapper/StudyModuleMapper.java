package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.StudyModuleResponse;
import com.tommydang.studycards.entity.StudyModule;
import org.springframework.stereotype.Component;

@Component
public class StudyModuleMapper {
    public StudyModuleResponse toResponse(StudyModule studyModule) {
        return new StudyModuleResponse(
                studyModule.getId(),
                studyModule.getName(),
                studyModule.getDescription(),
                studyModule.getAbbreviation(),
                studyModule.getCreditPoints(),
                studyModule.getRequiredLearnProgress()
        );
    }
}
