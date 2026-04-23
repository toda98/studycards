package com.tommydang.studycards.init.module;

import com.tommydang.studycards.entity.FieldOfStudy;
import com.tommydang.studycards.entity.StudyModule;
import com.tommydang.studycards.repository.FieldOfStudyRepository;
import com.tommydang.studycards.repository.StudyModuleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Component
@Order(2)
public class StudyModuleDataInitializer implements CommandLineRunner {
    private final StudyModuleRepository studyModuleRepository;
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public StudyModuleDataInitializer(
            StudyModuleRepository studyModuleRepository,
            FieldOfStudyRepository fieldOfStudyRepository
    ) {
        this.studyModuleRepository = studyModuleRepository;
        this.fieldOfStudyRepository = fieldOfStudyRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initializeStudyModules();
    }

    private void initializeStudyModules() throws Exception {
        Set<StudyModuleSeedData.StudyModuleFieldOfStudyName> studyModuleFieldOfStudyNameSet = StudyModuleSeedData.getStudyModuleFieldOfStudyNameSet();

        for (StudyModuleSeedData.StudyModuleFieldOfStudyName studyModuleFieldOfStudyName : studyModuleFieldOfStudyNameSet) {
            getOrCreateStudyModule(
                    studyModuleFieldOfStudyName.studyModule().getName(),
                    studyModuleFieldOfStudyName.studyModule().getDescription(),
                    studyModuleFieldOfStudyName.studyModule().getAbbreviation(),
                    studyModuleFieldOfStudyName.studyModule().getCreditPoints(),
                    studyModuleFieldOfStudyName.studyModule().getRequiredLearnProgress(),
                    studyModuleFieldOfStudyName.fieldOfStudyName()
            );

        }
    }

    private StudyModule getOrCreateStudyModule(
            String studyModuleName,
            String description,
            String abbreviation,
            int creditPoints,
            int requiredLearnProgress,
            String fieldOfStudyName
    ) throws Exception {
        Optional<StudyModule> studyModule = studyModuleRepository.findByName(studyModuleName);
        Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findByName(fieldOfStudyName);

        if (studyModule.isEmpty()) {
            StudyModule actualStudyModule = new StudyModule(
                    studyModuleName,
                    description,
                    abbreviation,
                    creditPoints,
                    requiredLearnProgress
            );
            studyModuleRepository.save(actualStudyModule);
            if (fieldOfStudy.isPresent()) {
                fieldOfStudy.get().addStudyModule(actualStudyModule);
            } else {
                throw new Exception("Field of Study not found");
            }

            return actualStudyModule;
        } else {
            if (fieldOfStudy.isPresent()) {
                Set<StudyModule> studyModuleSet = fieldOfStudy.get().getStudyModules();
                if (!studyModuleSet.contains(studyModule.get())) {
                    fieldOfStudy.get().addStudyModule(studyModule.get());
                }
            } else {
                throw new Exception("Field of Study not found");
            }
            return studyModule.get();
        }
    }
}
