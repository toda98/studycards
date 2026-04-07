package com.tommydang.studycards.service;

import com.tommydang.studycards.entity.StudyModule;
import com.tommydang.studycards.repository.StudyModuleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudyModuleService {
    private final StudyModuleRepository studyModuleRepository;

    public StudyModuleService (StudyModuleRepository studyModuleRepository) {
        this.studyModuleRepository = studyModuleRepository;
    }

    public Set<StudyModule> loadAllStudyModules() {
        Iterable<StudyModule> studyModules = studyModuleRepository.findAll();
        Set<StudyModule> studyModuleSet = new HashSet<>();
        for (StudyModule studyModule : studyModules) {
            studyModuleSet.add(studyModule);
        }
        return studyModuleSet;
    }
}
