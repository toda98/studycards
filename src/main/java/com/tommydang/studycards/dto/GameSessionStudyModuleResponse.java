package com.tommydang.studycards.dto;

import com.tommydang.studycards.enums.GameSessionStudyModuleStatus;

public class GameSessionStudyModuleResponse {
    private final Long id;
    private final Long studyModuleId;
    private final String studyModuleName;
    private final String studyModuleAbbreviation;
    private final int currentLearnProgress;
    private final int currentTries;
    private final int maxTries;
    private final GameSessionStudyModuleStatus status;

    public GameSessionStudyModuleResponse(
            Long id,
            Long studyModuleId,
            String studyModuleName,
            String studyModuleAbbreviation,
            int currentLearnProgress,
            int currentTries,
            int maxTries,
            GameSessionStudyModuleStatus status
    ) {
        this.id = id;
        this.studyModuleId = studyModuleId;
        this.studyModuleName = studyModuleName;
        this.studyModuleAbbreviation = studyModuleAbbreviation;
        this.currentLearnProgress = currentLearnProgress;
        this.currentTries = currentTries;
        this.maxTries = maxTries;
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public Long getStudyModuleId() {
        return studyModuleId;
    }
    public String getStudyModuleName() {
        return studyModuleName;
    }
    public String getStudyModuleAbbreviation() {
        return studyModuleAbbreviation;
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
}
