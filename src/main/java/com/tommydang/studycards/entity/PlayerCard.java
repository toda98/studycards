package com.tommydang.studycards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
@DiscriminatorValue("player_card")
public class PlayerCard extends Card {
    @Column(name = "energy_cost")
    private int energyCost;

    protected PlayerCard() {}

    public PlayerCard (
            String name,
            String description,
            Set<CardEffect> cardEffects,
            int energyCost
    ) {
        super(name, description, cardEffects);
        this.energyCost = energyCost;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }
}
