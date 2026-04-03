package com.tommydang.studycards.entity;

import com.tommydang.studycards.enums.GameSessionStudyModuleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class GameSessionStudyModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "game_session_id", nullable = false)
    private GameSession gameSession;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "study_module_id", nullable = false)
    private StudyModule studyModule;

    @Column(name = "current_learn_progress", nullable = false)
    private int currentLearnProgress;

    @Column(name = "current_tries", nullable = false)
    private int currentTries;

    @Column(name = "max_tries", nullable = false)
    private int maxTries;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private GameSessionStudyModuleStatus status;

    protected GameSessionStudyModule() {}

    public GameSessionStudyModule(
            GameSession gameSession,
            StudyModule studyModule,
            int currentLearnProgress,
            int currentTries,
            int maxTries,
            GameSessionStudyModuleStatus status
    ) {
        this.gameSession = gameSession;
        this.studyModule = studyModule;
        this.currentLearnProgress = currentLearnProgress;
        this.currentTries = currentTries;
        this.maxTries = maxTries;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public GameSession getGameSession() {
        return gameSession;
    }
    public StudyModule getStudyModule() {
        return studyModule;
    }
    public int getCurrentLearnProgress() {
        return currentLearnProgress;
    }
    public int getCurrentTries() {
        return currentTries;
    }
    public int getMaxTries() {
        return maxTries;
    }
    public GameSessionStudyModuleStatus getStatus() {
        return status;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }
    public void setStudyModule(StudyModule studyModule) {
        this.studyModule = studyModule;
    }
    public void setCurrentLearnProgress(int currentLearnProgress) {
        this.currentLearnProgress = currentLearnProgress;
    }
    public void setCurrentTries(int currentTries) {
        this.currentTries = currentTries;
    }
    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }
    public void setStatus(GameSessionStudyModuleStatus status) {
        this.status = status;
    }
}
