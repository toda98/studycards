package com.tommydang.studycards.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class StudyModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "module_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;

    @Column(name = "credit_points", nullable = false)
    private int creditPoints;

    @Column(name = "required_learn_progress", nullable = false)
    private int requiredLearnProgress;

    protected StudyModule() {}

    public StudyModule(
            String name,
            String description,
            String abbreviation,
            int creditPoints,
            int requiredLearnProgress
    ) {
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
        this.creditPoints = creditPoints;
        this.requiredLearnProgress = requiredLearnProgress;
    }

    public Long getId() {
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

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }
    public void setRequiredLearnProgress(int requiredLearnProgress) {
        this.requiredLearnProgress = requiredLearnProgress;
    }
}