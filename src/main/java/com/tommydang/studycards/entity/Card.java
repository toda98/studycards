package com.tommydang.studycards.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "card_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "card_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "card_card_effect",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "card_effect_id")
    )

    private Set<CardEffect> cardEffects = new HashSet<>();

    protected Card() {}

    public Card(
            String name,
            String description,
            Set<CardEffect> cardEffects) {
        this.name = name;
        this.description = description;
        this.cardEffects = cardEffects;
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
    public Set<CardEffect> getCardEffects() {
        return cardEffects;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCardEffects(Set<CardEffect> cardEffects) {
        this.cardEffects = cardEffects;
    }
}
