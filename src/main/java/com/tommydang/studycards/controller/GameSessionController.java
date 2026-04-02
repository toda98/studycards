package com.tommydang.studycards.controller;

import com.tommydang.studycards.dto.CreateGameSessionRequest;
import com.tommydang.studycards.dto.GameSessionResponse;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.exception.GameSessionNotFoundException;
import com.tommydang.studycards.mapper.GameSessionMapper;
import com.tommydang.studycards.service.GameSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameSessionController {
    private final GameSessionService gameSessionService;
    private final GameSessionMapper gameSessionMapper;

    public GameSessionController(GameSessionService gameSessionService, GameSessionMapper gameSessionMapper) {
        this.gameSessionService = gameSessionService;
        this.gameSessionMapper = gameSessionMapper;
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
}
