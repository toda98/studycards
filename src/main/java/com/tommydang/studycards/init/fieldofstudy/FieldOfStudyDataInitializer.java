package com.tommydang.studycards.init.fieldofstudy;

import com.tommydang.studycards.entity.FieldOfStudy;
import com.tommydang.studycards.repository.FieldOfStudyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Component
@Order(1)
public class FieldOfStudyDataInitializer implements CommandLineRunner {
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public FieldOfStudyDataInitializer(
            FieldOfStudyRepository fieldOfStudyRepository
    ) {
        this.fieldOfStudyRepository = fieldOfStudyRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        initializeFieldOfStudies();
    }

    private void initializeFieldOfStudies() {
        Set<FieldOfStudy> fieldOfStudySet = FieldOfStudySeedData.getFieldOfStudySet();

        for (FieldOfStudy fieldOfStudy : fieldOfStudySet) {
            getOrCreateFieldOfStudy(
                    fieldOfStudy.getName(),
                    fieldOfStudy.getDescription()
            );
        }
    }

    private FieldOfStudy getOrCreateFieldOfStudy(
            String name,
            String description
    ) {
        Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findByName(name);

        if (fieldOfStudy.isEmpty()) {
            FieldOfStudy actualFieldOfStudy = new FieldOfStudy(name, description);
            fieldOfStudyRepository.save(actualFieldOfStudy);
            return actualFieldOfStudy;
        } else {
            return fieldOfStudy.get();
        }
    }
}
