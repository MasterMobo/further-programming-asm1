package controllers.cards;

import models.card.InsuranceCard;
import models.card.InsuranceCardManager;
import models.customer.Customer;
import models.customer.CustomerManager;
import views.general.InsuranceCardView;
import utils.converters.DateConverter;
import utils.converters.TypeConverter;

import java.util.Date;
import java.util.Map;

public class InsuranceCardCreator {
    private InsuranceCardManager cardManager;
    private CustomerManager customerManager;
    private InsuranceCardView cardView;

    public InsuranceCardCreator(InsuranceCardManager cardManager, CustomerManager customerManager, InsuranceCardView cardView) {
        this.cardManager = cardManager;
        this.customerManager = customerManager;
        this.cardView = cardView;
    }

    public InsuranceCard create(Map<String, String> data) {
        String cardHolderId = data.get(InsuranceCardView.CARD_HOLDER);

        if (!customerManager.exists(cardHolderId)) {
            cardView.displayError("Card Holder does not exist");
            return null;
        }

        if (customerManager.hasInsuranceCard(cardHolderId)) {
            cardView.displayError("Card Holder already has an Insurance Card");
            return null;
        }

        String policyOwner = data.get(InsuranceCardView.POLICY_OWNER);

        try {
            TypeConverter<Date> dateConverter = new DateConverter();
            Date exipryDate = dateConverter.fromString(data.get(InsuranceCardView.EXPIRY_DATE));
            String cardNumber = cardManager.generateId();

            Customer cardHolder = customerManager.get(cardHolderId);
            cardHolder.setInsuranceCardNumber(cardNumber);

            InsuranceCard newCard = new InsuranceCard(cardNumber, cardHolderId, policyOwner, exipryDate);

            return cardManager.add(newCard);

        } catch (Exception e) {
            cardView.displayError("Invalid Date");
            return null;
        }

    }
}
