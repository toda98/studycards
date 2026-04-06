package com.tommydang.studycards.controller;

import com.tommydang.studycards.dto.CreateGameSessionRequest;
import com.tommydang.studycards.dto.GameSessionResponse;
import com.tommydang.studycards.dto.SelectedStudyModuleRequest;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.mapper.GameSessionMapper;
import com.tommydang.studycards.service.GameSessionService;
import com.tommydang.studycards.service.GameSessionStudyModuleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameSessionController {
    private final GameSessionService gameSessionService;
    private final GameSessionMapper gameSessionMapper;
    private final GameSessionStudyModuleService gameSessionStudyModuleService;

    public GameSessionController(
            GameSessionService gameSessionService,
            GameSessionMapper gameSessionMapper,
            GameSessionStudyModuleService gameSessionStudyModuleService
    ) {
        this.gameSessionService = gameSessionService;
        this.gameSessionMapper = gameSessionMapper;
        this.gameSessionStudyModuleService = gameSessionStudyModuleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSessionResponse> getGameSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(gameSessionMapper.toResponse(gameSessionService.getGameSessionById(id)));
    }

    @PostMapping
    public ResponseEntity<GameSessionResponse> createGameSession(@Valid @RequestBody CreateGameSessionRequest createGameSessionRequest) {
        GameSession gameSession = gameSessionService.createGameSession(createGameSessionRequest.getPlayerName(), createGameSessionRequest.getFieldOfStudy());
        return ResponseEntity.status(HttpStatus.CREATED).body(gameSessionMapper.toResponse(gameSession));
    }

    @PostMapping("/{id}/modules")
    public ResponseEntity<GameSessionResponse> assignStudyModulesToGameSession(
            @PathVariable Long id,
            @Valid @RequestBody SelectedStudyModuleRequest selectedStudyModuleRequest
    ) {
        Set<Long> studyModuleIds = selectedStudyModuleRequest.getSelectedStudyModuleIds();
        GameSession updatedGameSession = gameSessionStudyModuleService.assignStudyModulesToGameSession(id, studyModuleIds);
        return ResponseEntity.ok(gameSessionMapper.toResponse(updatedGameSession));
    }
}
