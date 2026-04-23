package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.FieldOfStudyResponse;
import com.tommydang.studycards.entity.FieldOfStudy;
import org.springframework.stereotype.Component;

@Component
public class FieldOfStudyMapper {
    public FieldOfStudyResponse toResponse(FieldOfStudy fieldOfStudy) {
        return new FieldOfStudyResponse(
                fieldOfStudy.getId(),
                fieldOfStudy.getName(),
                fieldOfStudy.getDescription()
        );
    }
}
