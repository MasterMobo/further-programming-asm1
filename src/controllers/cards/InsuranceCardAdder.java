package controllers.cards;

import models.card.InsuranceCard;
import models.card.InsuranceCardManager;

public class InsuranceCardAdder {
    private InsuranceCardManager cardManager;

    public InsuranceCardAdder(InsuranceCardManager cardManager) {
        this.cardManager = cardManager;
    }

    public InsuranceCard add(InsuranceCard card) {
        return cardManager.add(card);
    }
}
