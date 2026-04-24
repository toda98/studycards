package com.tommydang.studycards.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateGameSessionRequest {
    @NotBlank(message = "Player name must not be blank")
    private String playerName;

    @NotNull(message = "Field of study must not be blank")
    private Long fieldOfStudyId;

    public CreateGameSessionRequest() {}

    public CreateGameSessionRequest(String playerName, Long fieldOfStudyId) {
        this.playerName = playerName;
        this.fieldOfStudyId = fieldOfStudyId;
    }

    public String getPlayerName() {
        return playerName;
    }
    public Long getFieldOfStudyId() {
        return fieldOfStudyId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setFieldOfStudyId(Long fieldOfStudyId) {
        this.fieldOfStudyId = fieldOfStudyId;
    }
}
