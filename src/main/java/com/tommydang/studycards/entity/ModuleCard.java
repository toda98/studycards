package com.tommydang.studycards.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
@DiscriminatorValue("module_card")
public class ModuleCard extends Card {
    protected ModuleCard() {}

    public ModuleCard (
            String name,
            String description,
            Set<CardEffect> cardEffects
    ) {
        super(name, description, cardEffects);
    }
}
