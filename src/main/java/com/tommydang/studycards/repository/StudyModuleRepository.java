package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.StudyModule;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudyModuleRepository extends CrudRepository<StudyModule, Long> {
    Optional<StudyModule> findByName(String name);
}
