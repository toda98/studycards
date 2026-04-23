package com.tommydang.studycards.init.fieldofstudy;

import com.tommydang.studycards.entity.FieldOfStudy;

import java.util.HashSet;
import java.util.Set;

public class FieldOfStudySeedData {
    private static final FieldOfStudy COMPUTER_SCIENCE = new FieldOfStudy("Informatik", "");
    private static final FieldOfStudy BUSINESS_INFORMATICS = new FieldOfStudy("Wirtschaftsinformatik", "");
    private static final FieldOfStudy MATH = new FieldOfStudy("Mathe", "");

    private static final Set<FieldOfStudy> fieldOfStudySet = new HashSet<>(Set.of(
            COMPUTER_SCIENCE,
            BUSINESS_INFORMATICS,
            MATH
    ));

    private FieldOfStudySeedData() {}

    public static Set<FieldOfStudy> getFieldOfStudySet() {
        return fieldOfStudySet;
    }
}
