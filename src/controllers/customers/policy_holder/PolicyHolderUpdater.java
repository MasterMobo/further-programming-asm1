package controllers.customers.policy_holder;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;
import views.system.SystemViewManager;

import java.util.Map;
import java.util.Objects;

public class PolicyHolderUpdater extends ControllerOperator {
    public PolicyHolderUpdater() {
        super();
    }

    public PolicyHolderUpdater(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public PolicyHolder execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();
        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();

        String targetCustomerId = data.get(DependentView.CUSTOMER_ID);
        String newFullName = data.get(DependentView.CUSTOMER_NAME);
        String newCardNum = data.get(DependentView.CARD_NUM);

        if (!policyHolders.exists(targetCustomerId)) {
            message.displayError("Policy Holder does not exist");
            return null;
        }

        if (!cards.exists(newCardNum)) {
            message.displayError("Insurance Card does not exist");
            return null;
        }

        InsuranceCard newCard = cards.get(newCardNum);

        // Check if this customer owns this card
        if (!Objects.equals(newCard.getCardHolderId(), targetCustomerId)) {
            message.displayError("Policy Holder does not own this card");
            return null;
        }

        PolicyHolder updatedHolder = new PolicyHolder(targetCustomerId, newFullName, newCardNum);

        return policyHolders.update(targetCustomerId, updatedHolder);
    }
}
