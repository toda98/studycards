package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.CardEffectResponse;
import com.tommydang.studycards.entity.CardEffect;
import org.springframework.stereotype.Component;

@Component
public class CardEffectMapper {
    public CardEffectResponse toResponse(CardEffect cardEffect) {
        return new CardEffectResponse(
                cardEffect.getOperatorType(),
                cardEffect.getValue(),
                cardEffect.getResourceType(),
                cardEffect.getTargetType()
        );
    }
}
