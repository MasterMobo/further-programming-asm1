package controllers.cards;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.Map;

public class InsuranceCardDeleter extends ControllerOperator {
    public InsuranceCardDeleter() {
        super();
    }

    public InsuranceCardDeleter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public InsuranceCard execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();
        InsuranceCardView cardView = systemViewManager.getInsuranceCardView();

        InsuranceCardStorage cards = systemStorageManager.getCardStorage();
        CustomerStorageManager customers = systemStorageManager.getCustomerStorageManager();;

        String cardNum = data.get(InsuranceCardView.CARD_NUM);

        if (!cards.exists(cardNum)) {
            message.displayError("Insurance Card does not exist");
            return null;
        }

        if (!cardView.displayDeleteConfirm()) {
            message.displayMessage("Delete Canceled");
            return null;
        }

        // Remove card from owner
        InsuranceCard deletedCard = cards.delete(cardNum);
        Customer cardHolder = customers.getCustomer(deletedCard.getCardHolderId());

        if (cardHolder == null) {
            return deletedCard;
        }

        cardHolder.removeInsuranceCard();

        return cards.delete(cardNum);
    }
}
