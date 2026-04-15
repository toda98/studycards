package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.Card;
import com.tommydang.studycards.entity.PlayerCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerCardRepository extends CrudRepository<PlayerCard, Long> {
    Optional<Card> findByName(String name);
}
