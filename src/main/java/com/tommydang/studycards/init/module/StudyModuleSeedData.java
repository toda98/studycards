package com.tommydang.studycards.init.module;

import com.tommydang.studycards.entity.StudyModule;

import java.util.HashSet;
import java.util.Set;

public class StudyModuleSeedData {
    private static final StudyModule PDA = new StudyModule(
            "Programmierung, Datenstrukturen und Algorithmen",
            "",
            "PDA",
            9,
            45
    );
    private static final StudyModule OMP = new StudyModule(
            "Objektorientierte Modellierung und Programmierung",
            "",
            "OMP",
            9,
            45
    );
    private static final StudyModule DS = new StudyModule(
            "Diskrete Strukturen",
            "",
            "DS",
            6,
            30
    );

    private static final Set<StudyModule> studyModuleSet = new HashSet<>(Set.of(
            PDA,
            OMP,
            DS
    ));

    private StudyModuleSeedData() {}

    public static Set<StudyModule> getStudyModuleSet() {
        return studyModuleSet;
    }



    record StudyModuleFieldOfStudyName(StudyModule studyModule, String fieldOfStudyName) {}


    private static final StudyModuleFieldOfStudyName PDA_CS = new StudyModuleFieldOfStudyName(PDA, "Informatik");
    private static final StudyModuleFieldOfStudyName OMP_CS = new StudyModuleFieldOfStudyName(OMP, "Informatik");
    private static final StudyModuleFieldOfStudyName DS_CS = new StudyModuleFieldOfStudyName(DS, "Informatik");

    private static final StudyModuleFieldOfStudyName PDA_BI = new StudyModuleFieldOfStudyName(PDA, "Wirtschaftsinformatik");
    private static final StudyModuleFieldOfStudyName OMP_BI = new StudyModuleFieldOfStudyName(OMP, "Wirtschaftsinformatik");
    private static final StudyModuleFieldOfStudyName DS_BI = new StudyModuleFieldOfStudyName(DS, "Wirtschaftsinformatik");


    private static final Set<StudyModuleFieldOfStudyName> studyModuleFieldOfStudyNameSet = new HashSet<>(Set.of(
            PDA_CS,
            OMP_CS,
            DS_CS,
            PDA_BI,
            OMP_BI,
            DS_BI
    ));

    public static Set<StudyModuleFieldOfStudyName> getStudyModuleFieldOfStudyNameSet() {
        return studyModuleFieldOfStudyNameSet;
    }
}
