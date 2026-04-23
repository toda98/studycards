package com.tommydang.studycards.service;

import com.tommydang.studycards.entity.FieldOfStudy;
import com.tommydang.studycards.repository.FieldOfStudyRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FieldOfStudyService {
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public FieldOfStudyService(FieldOfStudyRepository fieldOfStudyRepository) {
        this.fieldOfStudyRepository = fieldOfStudyRepository;
    }

    public Set<FieldOfStudy> loadAllFieldOfStudies() {
        Iterable<FieldOfStudy> fieldOfStudies = fieldOfStudyRepository.findAll();
        Set<FieldOfStudy> fieldOfStudySet = new HashSet<>();
        for (FieldOfStudy fieldOfStudy : fieldOfStudies) {
            fieldOfStudySet.add(fieldOfStudy);
        }
        return fieldOfStudySet;
    }
}
