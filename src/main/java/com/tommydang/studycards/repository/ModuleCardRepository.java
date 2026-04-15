package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.Card;
import com.tommydang.studycards.entity.ModuleCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ModuleCardRepository extends CrudRepository<ModuleCard, Long> {
    Optional<Card> findByName(String name);
}
