package com.tommydang.studycards.dto;

public class StudyModuleResponse {
    private final long id;
    private final String name;
    private final String description;
    private final String abbreviation;
    private final int creditPoints;
    private final int requiredLearnProgress;

    public StudyModuleResponse(
            long id,
            String name,
            String description,
            String abbreviation,
            int creditPoints,
            int requiredLearnProgress) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
        this.creditPoints = creditPoints;
        this.requiredLearnProgress = requiredLearnProgress;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
    public int getCreditPoints() {
        return creditPoints;
    }
    public int getRequiredLearnProgress() {
        return requiredLearnProgress;
    }
}
