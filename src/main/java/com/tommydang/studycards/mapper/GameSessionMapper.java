package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.GameSessionResponse;
import com.tommydang.studycards.entity.GameSession;
import org.springframework.stereotype.Component;

@Component
public class GameSessionMapper {
    public GameSessionResponse toResponse(GameSession gameSession) {
        return new GameSessionResponse(
                gameSession.getId(),
                gameSession.getPlayerName(),
                gameSession.getSelectedFieldOfStudy(),
                gameSession.getCurrentSemester(),
                gameSession.getCurrentTurn(),
                gameSession.getMaxTurns(),
                gameSession.getCurrentStress(),
                gameSession.getCurrentEnergy(),
                gameSession.getMaxStress(),
                gameSession.getMaxEnergy(),
                gameSession.getStatus()
        );
    }
}
