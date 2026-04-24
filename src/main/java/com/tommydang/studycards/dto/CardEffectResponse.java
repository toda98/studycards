package com.tommydang.studycards.dto;

import com.tommydang.studycards.enums.OperatorType;
import com.tommydang.studycards.enums.ResourceType;
import com.tommydang.studycards.enums.TargetType;

public class CardEffectResponse {
    private final OperatorType operatorType;
    private final int value;
    private final ResourceType resourceType;
    private final TargetType targetType;

    public CardEffectResponse(
            OperatorType operatorType,
            int value,
            ResourceType resourceType,
            TargetType targetType
    ) {
        this.operatorType = operatorType;
        this.value = value;
        this.resourceType = resourceType;
        this.targetType = targetType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
    public int getValue() {
        return value;
    }
    public ResourceType getResourceType() {
        return resourceType;
    }
    public TargetType getTargetType() {
        return targetType;
    }
}
