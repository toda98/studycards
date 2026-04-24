package com.tommydang.studycards.init.card;

import com.tommydang.studycards.entity.CardEffect;
import com.tommydang.studycards.entity.ModuleCard;
import com.tommydang.studycards.entity.PlayerCard;
import com.tommydang.studycards.enums.OperatorType;
import com.tommydang.studycards.enums.ResourceType;
import com.tommydang.studycards.enums.TargetType;
import com.tommydang.studycards.repository.CardEffectRepository;
import com.tommydang.studycards.repository.CardRepository;
import com.tommydang.studycards.repository.ModuleCardRepository;
import com.tommydang.studycards.repository.PlayerCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class CardDataInitializer implements CommandLineRunner {
    private final CardRepository cardRepository;
    private final CardEffectRepository cardEffectRepository;
    private final PlayerCardRepository playerCardRepository;
    private final ModuleCardRepository moduleCardRepository;

    public CardDataInitializer(
            CardRepository cardRepository,
            CardEffectRepository cardEffectRepository,
            PlayerCardRepository playerCardRepository,
            ModuleCardRepository moduleCardRepository
    ) {
        this.cardRepository = cardRepository;
        this.cardEffectRepository = cardEffectRepository;
        this.playerCardRepository = playerCardRepository;
        this.moduleCardRepository = moduleCardRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        initializeCardEffects();
        initializePlayerCards();
        initializeModuleCards();
    }

    private void initializeCardEffects() {
        Set<CardEffect> effects = CardSeedData.getEffects();

        for (CardEffect effect : effects) {
            getOrCreateEffect(
                    effect.getOperatorType(),
                    effect.getValue(),
                    effect.getResourceType(),
                    effect.getTargetType()
            );
        }
    }

    private CardEffect getOrCreateEffect(
            OperatorType operatorType,
            int value,
            ResourceType resourceType,
            TargetType targetType
    ) {
        Optional<CardEffect> cardEffect = cardEffectRepository.findByOperatorTypeAndValueAndResourceTypeAndTargetType(
                operatorType, value, resourceType, targetType);

        if (cardEffect.isEmpty()) {
            CardEffect actualCardEffect = new CardEffect(operatorType, value, resourceType, targetType);
            cardEffectRepository.save(actualCardEffect);
            return actualCardEffect;
        } else {
            return cardEffect.get();
        }
    }

    private void initializePlayerCards() {
        Set<PlayerCard> playerCards = CardSeedData.getPlayerCards();

        for (PlayerCard playerCard : playerCards) {
            if (playerCardRepository.findByName(playerCard.getName()).isEmpty()) {
                playerCardRepository.save(new PlayerCard(
                        playerCard.getName(),
                        playerCard.getDescription(),
                        getOrCreateEffects(playerCard.getCardEffects()),
                        playerCard.getEnergyCost()
                ));
            }
        }
    }

    private void initializeModuleCards() {
        Set<ModuleCard> moduleCards = CardSeedData.getModuleCard();

        for (ModuleCard moduleCard : moduleCards) {
            if (moduleCardRepository.findByName(moduleCard.getName()).isEmpty()) {
                moduleCardRepository.save(new ModuleCard(
                   moduleCard.getName(),
                   moduleCard.getDescription(),
                   getOrCreateEffects(moduleCard.getCardEffects())
                ));
            }
        }
    }

    private Set<CardEffect> getOrCreateEffects(Set<CardEffect> effects) {
        Set<CardEffect> cardEffects = new HashSet<>();
        for (CardEffect effect : effects) {
            CardEffect actualEffect = getOrCreateEffect(
                    effect.getOperatorType(),
                    effect.getValue(),
                    effect.getResourceType(),
                    effect.getTargetType()
            );
            cardEffects.add(actualEffect);
        }
        return cardEffects;
    }
}
