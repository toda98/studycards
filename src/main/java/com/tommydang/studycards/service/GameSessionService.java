package com.tommydang.studycards.service;

import com.tommydang.studycards.entity.FieldOfStudy;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.enums.GameSessionStatus;
import com.tommydang.studycards.exception.FieldOfStudyNotFoundException;
import com.tommydang.studycards.exception.GameSessionNotFoundException;
import com.tommydang.studycards.repository.FieldOfStudyRepository;
import com.tommydang.studycards.repository.GameSessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameSessionService {
    private final GameSessionRepository gameSessionRepository;
    private final FieldOfStudyRepository fieldOfStudyRepository;

    public GameSessionService(GameSessionRepository gameSessionRepository, FieldOfStudyRepository fieldOfStudyRepository) {
        this.gameSessionRepository = gameSessionRepository;
        this.fieldOfStudyRepository = fieldOfStudyRepository;
    }

    public GameSession createGameSession(String playerName, Long fieldOfStudyId) {
        Optional<FieldOfStudy> fieldOfStudy = fieldOfStudyRepository.findById(fieldOfStudyId);
        if (fieldOfStudy.isEmpty()) {
            throw new FieldOfStudyNotFoundException("Id: [" + fieldOfStudyId + "] not found");
        }

        GameSession gameSession = new GameSession(
                playerName,
                fieldOfStudy.get(),
                1,
                1,
                15,
                0,
                10,
                100,
                10,
                GameSessionStatus.NEW
        );
        return gameSessionRepository.save(gameSession);
    }

    public GameSession getGameSessionById(Long id) throws GameSessionNotFoundException {
        Optional<GameSession> gameSession = gameSessionRepository.findByIdWithDetails(id);
        if (gameSession.isEmpty()) {
            throw new GameSessionNotFoundException("Id: [" + id + "] not found");
        }

        return gameSession.get();
    }
}
