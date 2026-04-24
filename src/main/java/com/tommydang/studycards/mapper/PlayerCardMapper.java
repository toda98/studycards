package com.tommydang.studycards.mapper;

import com.tommydang.studycards.dto.CardEffectResponse;
import com.tommydang.studycards.dto.PlayerCardResponse;
import com.tommydang.studycards.entity.CardEffect;
import com.tommydang.studycards.entity.PlayerCard;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PlayerCardMapper {
    private final CardEffectMapper cardEffectMapper;

    public PlayerCardMapper(CardEffectMapper cardEffectMapper) {
        this.cardEffectMapper = cardEffectMapper;
    }

    public PlayerCardResponse toResponse(PlayerCard playerCard) {
        return new PlayerCardResponse(
                playerCard.getId(),
                playerCard.getName(),
                playerCard.getDescription(),
                mapPlayerCardEffects(playerCard.getCardEffects()),
                playerCard.getEnergyCost()
        );
    }

    private Set<CardEffectResponse> mapPlayerCardEffects(Set<CardEffect> cardEffects) {
        Set<CardEffectResponse> cardEffectResponseSet = new HashSet<>();

        for (CardEffect cardEffect : cardEffects) {
            cardEffectResponseSet.add(cardEffectMapper.toResponse(cardEffect));
        }

        return cardEffectResponseSet;
    }
}
