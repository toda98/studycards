package com.tommydang.studycards.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateGameSessionRequest {
    @NotBlank
    private String playerName;

    @NotBlank
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
