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
import views.system.SystemViewManager;

import java.util.Date;
import java.util.Map;

public class InsuranceCardCreator {
    private SystemStorageManager systemStorageManager;
    private SystemViewManager systemViewManager;

    public InsuranceCardCreator() {
    }

    public InsuranceCardCreator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    public InsuranceCard create(Map<String, String> data) {
        MessageView messageView = systemViewManager.getMessageView();
        CustomerStorageManager customerStorageManager = systemStorageManager.getCustomerStorageManager();
        InsuranceCardStorage cardStorage = systemStorageManager.getCardStorage();

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
            String cardNumber = cardStorage.generateId();

            Customer cardHolder = customerStorageManager.getCustomer(cardHolderId);
            cardHolder.setInsuranceCardNumber(cardNumber);

            InsuranceCard newCard = new InsuranceCard(cardNumber, cardHolderId, policyOwner, exipryDate);

            return cardStorage.add(newCard);

        } catch (Exception e) {
            messageView.displayError("Invalid Date");
            return null;
        }

    }
}
