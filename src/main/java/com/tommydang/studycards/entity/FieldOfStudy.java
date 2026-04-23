package com.tommydang.studycards.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class FieldOfStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "field_of_study_study_module",
            joinColumns = @JoinColumn(name = "field_of_study_id"),
            inverseJoinColumns = @JoinColumn(name = "study_module_id")
    )
    private Set<StudyModule> studyModules = new HashSet<>();

    protected FieldOfStudy() {}

    public FieldOfStudy(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
    }

    public void addStudyModule(StudyModule studyModule) {
        studyModules.add(studyModule);
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
    public Set<StudyModule> getStudyModules() {
        return studyModules;
    }
}
