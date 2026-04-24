package com.tommydang.studycards.repository;

import com.tommydang.studycards.entity.GameSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
    @Query("SELECT g " +
           "FROM GameSession g " +
           "LEFT JOIN FETCH " +
           "g.gameSessionStudyModules " +
           "WHERE g.id = :id"
    )
    Optional<GameSession> findByIdWithModules(@Param("id") Long id);
}
