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

    public InsuranceCardController(InsuranceCardManager cardManager, CustomerManager customerManager, InsuranceCardView cardView) {
        this.cardManager = cardManager;
        this.customerManager = customerManager;
        this.cardView = cardView;

        cardCreator =  new InsuranceCardCreator(cardManager, customerManager, cardView);
    }

    public InsuranceCard createCard() {
        cardView.displayMessage("Creating Insurance Card...");

        Map<String, String> data = cardView.displayCreateCardForm();
        InsuranceCard newCard = cardCreator.create(data);

        if (newCard == null) {
            return null;
        }

        cardView.displayMessage("Successfully added new insurance card:");
        cardView.displayCard(newCard);

        return newCard;
    }
}
