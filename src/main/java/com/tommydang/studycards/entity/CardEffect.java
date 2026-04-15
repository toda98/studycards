package com.tommydang.studycards.entity;

import com.tommydang.studycards.enums.OperatorType;
import com.tommydang.studycards.enums.ResourceType;
import com.tommydang.studycards.enums.TargetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Check;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CardEffect {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "operator_type", nullable = false)
    private OperatorType operatorType;

    @Check(constraints = "value >= 0")
    @Column(name = "value", nullable = false)
    private int value;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "resource_type", nullable = false)
    private ResourceType resourceType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false)
    private TargetType targetType;

    @ManyToMany(mappedBy = "cardEffects")
    private Set<Card> cards = new HashSet<>();

    protected CardEffect() {}

    public CardEffect(
            OperatorType operatorType,
            int value,
            ResourceType resourceType,
            TargetType targetType) {
        this.operatorType = operatorType;
        this.value = value;
        this.resourceType = resourceType;
        this.targetType = targetType;
    }

    public long getId() {
        return id;
    }
    public int getValue() {
        return value;
    }
    public OperatorType getOperatorType() {
        return operatorType;
    }
    public ResourceType getResourceType() {
        return resourceType;
    }
    public TargetType getTargetType() {
        return targetType;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }
    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }
}
