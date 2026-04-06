package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.GameSessionStudyModuleResponse;
import com.tommydang.studycards.entity.GameSessionStudyModule;
import org.springframework.stereotype.Component;

@Component
public class GameSessionStudyModuleMapper {
    public GameSessionStudyModuleResponse toResponse(GameSessionStudyModule gameSessionStudyModule) {
        return new GameSessionStudyModuleResponse(
                gameSessionStudyModule.getId(),
                gameSessionStudyModule.getStudyModule().getId(),
                gameSessionStudyModule.getStudyModule().getName(),
                gameSessionStudyModule.getStudyModule().getAbbreviation(),
                gameSessionStudyModule.getCurrentLearnProgress(),
                gameSessionStudyModule.getCurrentTries(),
                gameSessionStudyModule.getMaxTries(),
                gameSessionStudyModule.getStatus()
        );
    }
}
