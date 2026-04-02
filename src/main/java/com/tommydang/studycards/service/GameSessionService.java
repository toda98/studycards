package com.tommydang.studycards.service;

import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.enums.GameSessionStatus;
import com.tommydang.studycards.exception.GameSessionNotFoundException;
import com.tommydang.studycards.repository.GameSessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameSessionService {
    private final GameSessionRepository gameSessionRepository;

    public GameSessionService(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    public GameSession createGameSession(String playerName, String fieldOfStudy) {
        GameSession gameSession = new GameSession(
                playerName,
                fieldOfStudy,
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
        Optional<GameSession> gameSession = gameSessionRepository.findById(id);
        
        if (gameSession.isEmpty()) {
            throw new GameSessionNotFoundException("Id: [" + id + "] not found");
        }

        return gameSession.get();
    }
}
