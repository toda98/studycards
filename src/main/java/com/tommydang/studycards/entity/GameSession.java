package com.tommydang.studycards.entity;

import com.tommydang.studycards.enums.GameSessionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "player_name", nullable = false, length = 512)
    private String playerName;

    @NotBlank
    @Column(name = "selected_field_of_study", nullable = false, length = 512)
    private String selectedFieldOfStudy;

    @Column(name = "current_semester", nullable = false)
    private int currentSemester;

    @Column(name = "current_turn", nullable = false)
    private int currentTurn;

    @Column(name = "max_turns", nullable = false)
    private int maxTurns;

    @Column(name = "current_stress", nullable = false)
    private int currentStress;

    @Column(name = "current_energy", nullable = false)
    private int currentEnergy;

    @Column(name = "max_stress", nullable = false)
    private int maxStress;

    @Column(name = "max_energy", nullable = false)
    private int maxEnergy;

    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private GameSessionStatus status;

    protected GameSession() {}

    public GameSession(
            String playerName,
            String selectedFieldOfStudy,
            int currentSemester,
            int currentTurn,
            int maxTurns,
            int currentStress,
            int currentEnergy,
            int maxStress,
            int maxEnergy,
            GameSessionStatus status
    ) {
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
    public int getCurrentTurn() {
        return currentTurn;
    }
    public int getCurrentSemester() {
        return currentSemester;
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

    public void setId(Long id) {
        this.id = id;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setSelectedFieldOfStudy(String selectedFieldOfStudy) {
        this.selectedFieldOfStudy = selectedFieldOfStudy;
    }
    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }
    public void setMaxTurns(int maxTurns) {
        this.maxTurns = maxTurns;
    }
    public void setCurrentStress(int currentStress) {
        this.currentStress = currentStress;
    }
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }
    public void setMaxStress(int maxStress) {
        this.maxStress = maxStress;
    }
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }
    public void setStatus(GameSessionStatus status) {
        this.status = status;
    }
}
