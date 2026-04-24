package com.tommydang.studycards.dto;

import java.util.Set;

public class PlayerCardResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Set<CardEffectResponse> cardEffects;
    private final int energyCost;

    public PlayerCardResponse(
            Long id,
            String name,
            String description,
            Set<CardEffectResponse> cardEffects,
            int energyCost
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cardEffects = cardEffects;
        this.energyCost = energyCost;
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
    public Set<CardEffectResponse> getCardEffects() {
        return cardEffects;
    }
    public int getEnergyCost() {
        return energyCost;
    }
}
