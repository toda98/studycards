package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.CardEffect;
import com.tommydang.studycards.enums.OperatorType;
import com.tommydang.studycards.enums.ResourceType;
import com.tommydang.studycards.enums.TargetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardEffectRepository extends CrudRepository<CardEffect, Long> {
    Optional<CardEffect> findByOperatorTypeAndValueAndResourceTypeAndTargetType(
            OperatorType operatorType,
            int value,
            ResourceType resourceType,
            TargetType targetType
    );
}
