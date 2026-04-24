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
           "LEFT JOIN FETCH " +
              "g.handCards " +
              "WHERE g.id = :id "
    )
    Optional<GameSession> findByIdWithDetails(@Param("id") Long id);
}
