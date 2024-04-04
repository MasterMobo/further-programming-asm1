package controllers.cards;

import models.card.InsuranceCard;
import models.card.InsuranceCardManager;
import models.customer.CustomerManager;
import views.general.InsuranceCardView;

import java.util.Map;

public class InsuranceCardController {
    InsuranceCardManager cardManager; // Model
    InsuranceCardView cardView; // View
    CustomerManager customerManager;
    InsuranceCardCreator cardCreator;
    InsuranceCardAdder cardAdder;

    public InsuranceCardController(InsuranceCardManager cardManager, CustomerManager customerManager, InsuranceCardView cardView) {
        this.cardManager = cardManager;
        this.customerManager = customerManager;
        this.cardView = cardView;

        cardCreator =  new InsuranceCardCreator(cardManager, customerManager, cardView);
        cardAdder = new InsuranceCardAdder(cardManager);
    }

    public InsuranceCard createCard() {
        cardView.displayMessage("Creating Insurance Card...");

        Map<String, String> data = cardView.displayCreateCardForm();
        InsuranceCard card = cardCreator.create(data);

        // Card might be null if creation failed
        if (card == null) {
            return null;
        }

        InsuranceCard newCard = cardAdder.add(card);
        cardView.displayCard(newCard);

        return newCard;
    }
}
