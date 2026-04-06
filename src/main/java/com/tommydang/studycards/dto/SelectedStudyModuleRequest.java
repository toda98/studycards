package com.tommydang.studycards.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public class SelectedStudyModuleRequest {
    @NotEmpty(message = "At least one study module must be selected")
    private Set<Long> selectedStudyModuleIds;

    public SelectedStudyModuleRequest() { }

    public SelectedStudyModuleRequest(Set<Long> selectedStudyModuleIds) {
        this.selectedStudyModuleIds = selectedStudyModuleIds;
    }

    public Set<Long> getSelectedStudyModuleIds() {
        return selectedStudyModuleIds;
    }

    public void setSelectedStudyModuleIds(Set<Long> selectedStudyModuleIds) {
        this.selectedStudyModuleIds = selectedStudyModuleIds;
    }
}
