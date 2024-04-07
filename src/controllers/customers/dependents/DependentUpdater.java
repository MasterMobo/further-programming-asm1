package controllers.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.system.SystemViewManager;

import java.util.Map;
import java.util.Objects;

public class DependentUpdater extends ControllerOperator {
    public DependentUpdater() {
        super();
    }

    public DependentUpdater(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Dependent execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();
        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();

        String targetDependentId = data.get(DependentView.CUSTOMER_ID);
        String newFullName = data.get(DependentView.CUSTOMER_NAME);
        String newCardNum = data.get(DependentView.CARD_NUM);

        if (!dependents.exists(targetDependentId)) {
            message.displayError("Dependent does not exist");
            return null;
        }

        if (!cards.exists(newCardNum)) {
            message.displayError("Insurance Card does not exist");
            return null;
        }

        InsuranceCard newCard = cards.get(newCardNum);

        // Check if this customer owns this card
        if (!Objects.equals(newCard.getCardHolderId(), targetDependentId)) {
            message.displayError("Dependent does not own this card");
            return null;
        }

        Dependent updatedDependent = new Dependent(targetDependentId, newFullName, newCardNum);

        return dependents.update(targetDependentId, updatedDependent);
    }
}
