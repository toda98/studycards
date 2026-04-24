package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.FieldOfStudy;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FieldOfStudyRepository extends CrudRepository<FieldOfStudy, Long> {
    Optional<FieldOfStudy> findByName(String name);
}
