package com.tommydang.studycards.init.card;

import com.tommydang.studycards.entity.CardEffect;
import com.tommydang.studycards.entity.ModuleCard;
import com.tommydang.studycards.entity.PlayerCard;
import com.tommydang.studycards.enums.OperatorType;
import com.tommydang.studycards.enums.ResourceType;
import com.tommydang.studycards.enums.TargetType;

import java.util.HashSet;
import java.util.Set;

public class CardSeedData {
    private static final CardEffect ADD_3_LEARN_SRM = new CardEffect(OperatorType.ADD, 3, ResourceType.LEARN_PROGRESS, TargetType.SINGLE_RANDOM_MODULE);
    private static final CardEffect ADD_4_LEARN_SRM = new CardEffect(OperatorType.ADD, 4, ResourceType.LEARN_PROGRESS, TargetType.SINGLE_RANDOM_MODULE);
    private static final CardEffect SUB_2_STRESS_PLAYER = new CardEffect(OperatorType.SUB, 2, ResourceType.STRESS, TargetType.PLAYER);
    private static final CardEffect SUB_1_LEARN_SRM = new CardEffect(OperatorType.SUB, 1, ResourceType.LEARN_PROGRESS, TargetType.SINGLE_RANDOM_MODULE);
    private static final CardEffect SUB_3_LEARN_SRM = new CardEffect(OperatorType.SUB, 3, ResourceType.LEARN_PROGRESS, TargetType.SINGLE_RANDOM_MODULE);

    private static final Set<CardEffect> effects = new HashSet<>(Set.of(
            ADD_3_LEARN_SRM,
            ADD_4_LEARN_SRM,
            SUB_2_STRESS_PLAYER,
            SUB_1_LEARN_SRM,
            SUB_3_LEARN_SRM
    ));


    private static final PlayerCard LEARNING = new PlayerCard("Lernen","", new HashSet<>(Set.of(ADD_3_LEARN_SRM)), 1);
    private static final PlayerCard STUDYING_IN_GROUP = new PlayerCard("Lernen mit Lerngruppe", "", new HashSet<>(Set.of(ADD_4_LEARN_SRM)), 3);
    private static final PlayerCard COFFEE_BREAK = new PlayerCard( "Kaffeepause", "", new HashSet<>(Set.of(SUB_2_STRESS_PLAYER)), 1);

    private static final Set<PlayerCard> playerCards = new HashSet<>(Set.of(
            LEARNING,
            STUDYING_IN_GROUP,
            COFFEE_BREAK
    ));


    private static final ModuleCard CHALLENGING_TASK = new ModuleCard("Schwierige Aufgabe", "", new HashSet<>(Set.of(SUB_1_LEARN_SRM)));
    private static final ModuleCard SURPRISE_TEST = new ModuleCard("Unangekündigter Test", "", new HashSet<>(Set.of(SUB_3_LEARN_SRM)));

    private static final Set<ModuleCard> moduleCard = new HashSet<>(Set.of(
            CHALLENGING_TASK,
            SURPRISE_TEST
    ));

    private CardSeedData() {}

    public static Set<CardEffect> getEffects() {
        return effects;
    }
    public static Set<PlayerCard> getPlayerCards() {
        return playerCards;
    }
    public static Set<ModuleCard> getModuleCard() {
        return moduleCard;
    }
}
