package controllers.cards;

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.system.SystemStorageManager;
import utils.converters.DateConverter;
import utils.converters.TypeConverter;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class InsuranceCardUpdater extends ControllerOperator {
    public InsuranceCardUpdater() {
        super();
    }

    public InsuranceCardUpdater(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceCard execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();

        CustomerStorageManager customers = systemStorageManager.getCustomerStorageManager();
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();

        String targetCardNum = data.get(InsuranceCardView.CARD_NUM);

        if (!cards.exists(targetCardNum)) {
            message.displayError("Insurance Card does not exist");
            return null;
        }

        String newOwnerId = data.get(InsuranceCardView.CARD_HOLDER);

        if (!customers.customerExists(newOwnerId)) {
            message.displayError("Customer does not exist");
            return null;
        }

        Customer newOwner = customers.getCustomer(newOwnerId);

        // Check if new customer owns this card
        if (!Objects.equals(newOwner.getInsuranceCardNumber(), targetCardNum)) {
            message.displayError("Customer does not own this card");
            return null;
        }

        String newPolicyOwner = data.get(InsuranceCardView.POLICY_OWNER);

        try {
            TypeConverter<Date> dateConverter = new DateConverter();
            Date newExpDate = dateConverter.fromString(data.get(InsuranceCardView.EXPIRY_DATE));

            InsuranceCard updatedCard = new InsuranceCard(targetCardNum, newOwnerId, newPolicyOwner, newExpDate);

            return cards.update(targetCardNum, updatedCard);

        } catch (IllegalArgumentException exception) {
            message.displayError("Invalid Date");
            return null;
        }

    }
}
