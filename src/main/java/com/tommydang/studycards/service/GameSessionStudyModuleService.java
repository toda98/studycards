package com.tommydang.studycards.service;

import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.entity.GameSessionStudyModule;
import com.tommydang.studycards.entity.StudyModule;
import com.tommydang.studycards.enums.GameSessionStudyModuleStatus;
import com.tommydang.studycards.exception.GameSessionNotFoundException;
import com.tommydang.studycards.exception.StudyModuleNotFoundException;
import com.tommydang.studycards.repository.GameSessionRepository;
import com.tommydang.studycards.repository.GameSessionStudyModuleRepository;
import com.tommydang.studycards.repository.StudyModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class GameSessionStudyModuleService {
    private final GameSessionRepository gameSessionRepository;
    private final StudyModuleRepository studyModuleRepository;
    private final GameSessionStudyModuleRepository gameSessionStudyModuleRepository;

    public GameSessionStudyModuleService(
            GameSessionRepository gameSessionRepository,
            StudyModuleRepository studyModuleRepository,
            GameSessionStudyModuleRepository gameSessionStudyModuleRepository
    ) {
        this.gameSessionRepository = gameSessionRepository;
        this.studyModuleRepository = studyModuleRepository;
        this.gameSessionStudyModuleRepository = gameSessionStudyModuleRepository;
    }

    @Transactional
    public GameSession assignStudyModulesToGameSession(Long gameSessionId, Set<Long> selectedStudyModuleIds) {
        GameSession actualGameSession = loadGameSessionOrThrow(gameSessionId);
        Set<StudyModule> studyModuleSet = loadSelectedStudyModulesOrThrow(selectedStudyModuleIds);
        Set<GameSessionStudyModule> gameSessionStudyModules = buildGameSessionStudyModules(actualGameSession, studyModuleSet);
        gameSessionStudyModuleRepository.saveAll(gameSessionStudyModules);
        actualGameSession.addGameSessionStudyModules(gameSessionStudyModules);
        return actualGameSession;
    }

    private GameSession loadGameSessionOrThrow(Long gameSessionId) {
        Optional<GameSession> gameSession = gameSessionRepository.findById(gameSessionId);
        if (gameSession.isEmpty()) {
            throw new GameSessionNotFoundException("Id: [" + gameSessionId + "] not found");
        }
        return gameSession.get();
    }

    private Set<StudyModule> loadSelectedStudyModulesOrThrow(Set<Long> selectedStudyModuleIds) {
        Iterable<StudyModule> studyModules = studyModuleRepository.findAllById(selectedStudyModuleIds);
        Set<StudyModule> studyModuleSet = new HashSet<>();
        for (StudyModule studyModule : studyModules) {
            studyModuleSet.add(studyModule);
        }
        if (selectedStudyModuleIds.size() != studyModuleSet.size()) {
            throw new StudyModuleNotFoundException("One or more study module IDs were not found");
        }

        return studyModuleSet;
    }

    private Set<GameSessionStudyModule> buildGameSessionStudyModules(GameSession actualGameSession, Set<StudyModule> studyModuleSet) {
        Set<GameSessionStudyModule> gameSessionStudyModules = new HashSet<>();
        for (StudyModule studyModule : studyModuleSet) {
            gameSessionStudyModules.add(
                    new GameSessionStudyModule(
                            actualGameSession,
                            studyModule,
                            0,
                            0,
                            3,
                            GameSessionStudyModuleStatus.IN_PROGRESS
                    )
            );
        }
        return gameSessionStudyModules;
    }
}
