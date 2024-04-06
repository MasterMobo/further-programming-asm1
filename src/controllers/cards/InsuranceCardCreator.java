package controllers.cards;

import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import utils.converters.DateConverter;
import utils.converters.TypeConverter;
import views.general.MessageView;
import views.general.SystemView;

import java.util.Date;
import java.util.Map;

public class InsuranceCardCreator {
    private SystemStorageManager systemStorageManager;
    private SystemView systemView;

    public InsuranceCardCreator() {
    }

    public InsuranceCardCreator(SystemStorageManager systemStorageManager, SystemView systemView) {
        this.systemStorageManager = systemStorageManager;
        this.systemView = systemView;
    }

    public InsuranceCard create(Map<String, String> data) {
        MessageView messageView = systemView.getMessageView();
        CustomerStorageManager customerStorageManager = systemStorageManager.getCustomerManager();
        InsuranceCardStorage cardManager = systemStorageManager.getCardManager();

        String cardHolderId = data.get(InsuranceCardView.CARD_HOLDER);

        if (!customerStorageManager.customerExists(cardHolderId)) {
            messageView.displayError("Card Holder does not exist");
            return null;
        }

        if (customerStorageManager.hasInsuranceCard(cardHolderId)) {
            messageView.displayError("Card Holder already has an Insurance Card");
            return null;
        }

        String policyOwner = data.get(InsuranceCardView.POLICY_OWNER);

        try {
            TypeConverter<Date> dateConverter = new DateConverter();
            Date exipryDate = dateConverter.fromString(data.get(InsuranceCardView.EXPIRY_DATE));
            String cardNumber = cardManager.generateId();

            Customer cardHolder = customerStorageManager.getCustomer(cardHolderId);
            cardHolder.setInsuranceCardNumber(cardNumber);

            InsuranceCard newCard = new InsuranceCard(cardNumber, cardHolderId, policyOwner, exipryDate);

            return cardManager.add(newCard);

        } catch (Exception e) {
            messageView.displayError("Invalid Date");
            return null;
        }

    }
}
