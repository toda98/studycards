package com.tommydang.studycards.dto;

import com.tommydang.studycards.enums.GameSessionStatus;

import java.util.Set;

public class GameSessionResponse {
    private final Long id;
    private final String playerName;
    private final String selectedFieldOfStudy;
    private final int currentSemester;
    private final int currentTurn;
    private final int maxTurns;
    private final int currentStress;
    private final int currentEnergy;
    private final int maxStress;
    private final int maxEnergy;
    private final GameSessionStatus status;
    private final Set<GameSessionStudyModuleResponse> gameSessionStudyModules;
    private final int totalCreditPoints;

    public GameSessionResponse(
            Long id,
            String playerName,
            String selectedFieldOfStudy,
            int currentSemester,
            int currentTurn,
            int maxTurns,
            int currentStress,
            int currentEnergy,
            int maxStress,
            int maxEnergy,
            GameSessionStatus status,
            Set<GameSessionStudyModuleResponse> gameSessionStudyModules,
            int totalCreditPoints
    ) {
        this.id = id;
        this.playerName = playerName;
        this.selectedFieldOfStudy = selectedFieldOfStudy;
        this.currentSemester = currentSemester;
        this.currentTurn = currentTurn;
        this.maxTurns = maxTurns;
        this.currentStress = currentStress;
        this.currentEnergy = currentEnergy;
        this.maxStress = maxStress;
        this.maxEnergy = maxEnergy;
        this.status = status;
        this.gameSessionStudyModules = gameSessionStudyModules;
        this.totalCreditPoints = totalCreditPoints;
    }

    public Long getId() {
        return id;
    }
    public String getPlayerName() {
        return playerName;
    }
    public String getSelectedFieldOfStudy() {
        return selectedFieldOfStudy;
    }
    public int getCurrentSemester() {
        return currentSemester;
    }
    public int getCurrentTurn() {
        return currentTurn;
    }
    public int getMaxTurns() {
        return maxTurns;
    }
    public int getCurrentStress() {
        return currentStress;
    }
    public int getCurrentEnergy() {
        return currentEnergy;
    }
    public int getMaxStress() {
        return maxStress;
    }
    public int getMaxEnergy() {
        return maxEnergy;
    }
    public GameSessionStatus getStatus() {
        return status;
    }
    public Set<GameSessionStudyModuleResponse> getGameSessionStudyModules() {
        return gameSessionStudyModules;
    }
    public int getTotalCreditPoints() {
        return totalCreditPoints;
    }
}
