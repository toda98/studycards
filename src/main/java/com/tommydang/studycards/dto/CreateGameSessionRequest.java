package com.tommydang.studycards.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class CreateGameSessionRequest {
    @NotBlank(message = "Player name must not be blank")
    private String playerName;

    @NotBlank(message = "Field of study must not be blank")
    private String fieldOfStudy;

    public CreateGameSessionRequest() {}

    public CreateGameSessionRequest(String playerName, String fieldOfStudy) {
        this.playerName = playerName;
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getPlayerName() {
        return playerName;
    }
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}
