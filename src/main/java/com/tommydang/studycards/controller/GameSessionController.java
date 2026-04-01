package com.tommydang.studycards.controller;

import com.tommydang.studycards.dto.CreateGameSessionRequest;
import com.tommydang.studycards.entity.GameSession;
import com.tommydang.studycards.service.GameSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameSessionController {
    private final GameSessionService gameSessionService;

    public GameSessionController(GameSessionService gameSessionService) {
        this.gameSessionService = gameSessionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSession> getGameSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(gameSessionService.getGameSessionById(id));
    }

    @PostMapping
    public ResponseEntity<GameSession> createGameSession(@Valid @RequestBody CreateGameSessionRequest createGameSessionRequest) {
        GameSession gameSession = gameSessionService.createGameSession(createGameSessionRequest.getPlayerName(), createGameSessionRequest.getFieldOfStudy());
        return ResponseEntity.status(HttpStatus.CREATED).body(gameSession);
    }
}
