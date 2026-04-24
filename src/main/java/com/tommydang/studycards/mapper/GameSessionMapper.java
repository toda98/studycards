package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.GameSessionResponse;
import com.tommydang.studycards.dto.GameSessionStudyModuleResponse;
import com.tommydang.studycards.dto.PlayerCardResponse;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.entity.GameSessionStudyModule;
import com.tommydang.studycards.entity.PlayerCard;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GameSessionMapper {
    private final GameSessionStudyModuleMapper gameSessionStudyModuleMapper;
    private final PlayerCardMapper playerCardMapper;

    public GameSessionMapper(GameSessionStudyModuleMapper gameSessionStudyModuleMapper, PlayerCardMapper playerCardMapper) {
        this.gameSessionStudyModuleMapper = gameSessionStudyModuleMapper;
        this.playerCardMapper = playerCardMapper;
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
                gameSession.getTotalCreditPoints(),
                mapHandCards(gameSession.getHandCards())
        );
    }

    private Set<GameSessionStudyModuleResponse> mapGameSessionStudyModules(Set<GameSessionStudyModule> gameSessionStudyModuleSet) {
        Set<GameSessionStudyModuleResponse> gameSessionStudyModuleResponse = new HashSet<>();

        for (GameSessionStudyModule gameSessionStudyModule : gameSessionStudyModuleSet) {
            gameSessionStudyModuleResponse.add(gameSessionStudyModuleMapper.toResponse(gameSessionStudyModule));
        }

        return gameSessionStudyModuleResponse;
    }

    private Set<PlayerCardResponse> mapHandCards(Set<PlayerCard> playerCardsSet) {
        Set<PlayerCardResponse> playerCardResponseSet = new HashSet<>();

        for (PlayerCard playerCard : playerCardsSet) {
            playerCardResponseSet.add(playerCardMapper.toResponse(playerCard));
        }

        return playerCardResponseSet;
    }
}
