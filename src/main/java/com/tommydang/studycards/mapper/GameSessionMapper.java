package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.GameSessionResponse;
import com.tommydang.studycards.dto.GameSessionStudyModuleResponse;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.entity.GameSessionStudyModule;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GameSessionMapper {
    private final GameSessionStudyModuleMapper gameSessionStudyModuleMapper;

    public GameSessionMapper(GameSessionStudyModuleMapper gameSessionStudyModuleMapper) {
        this.gameSessionStudyModuleMapper = gameSessionStudyModuleMapper;
    }

    public GameSessionResponse toResponse(GameSession gameSession) {
        return new GameSessionResponse(
                gameSession.getId(),
                gameSession.getPlayerName(),
                gameSession.getSelectedFieldOfStudy().getName(),
                gameSession.getCurrentSemester(),
                gameSession.getCurrentTurn(),
                gameSession.getMaxTurns(),
                gameSession.getCurrentStress(),
                gameSession.getCurrentEnergy(),
                gameSession.getMaxStress(),
                gameSession.getMaxEnergy(),
                gameSession.getStatus(),
                mapGameSessionStudyModules(gameSession.getGameSessionStudyModules()),
                gameSession.getTotalCreditPoints()
        );
    }

    private Set<GameSessionStudyModuleResponse> mapGameSessionStudyModules(Set<GameSessionStudyModule> gameSessionStudyModuleSet) {
        Set<GameSessionStudyModuleResponse> gameSessionStudyModuleResponse = new HashSet<>();

        for (GameSessionStudyModule gameSessionStudyModule : gameSessionStudyModuleSet) {
            gameSessionStudyModuleResponse.add(gameSessionStudyModuleMapper.toResponse(gameSessionStudyModule));
        }

        return gameSessionStudyModuleResponse;
    }
}
