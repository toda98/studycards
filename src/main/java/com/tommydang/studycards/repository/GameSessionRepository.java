package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.GameSession;
import org.springframework.data.repository.CrudRepository;

public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
}
