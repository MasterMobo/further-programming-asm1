package controllers.customers.policy_holder;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.customers.PolicyHolderView;
import views.system.SystemViewManager;

import java.util.Map;

public class PolicyHolderDeleter extends ControllerOperator {
    public PolicyHolderDeleter() {
        super();
    }

    public PolicyHolderDeleter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Object execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();
        PolicyHolderView policyHolderView = systemViewManager.getPolicyHolderView();

        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();
        String id = data.get(PolicyHolderView.CUSTOMER_ID);

        if (!policyHolders.exists(id)) {
            message.displayError("Policy Holder does not exist");
            return null;
        }

        if (!policyHolderView.displayDeleteConfirm()) {
            message.displayMessage("Delete canceled");
            return null;
        }

        return policyHolders.delete(id);
    }
}
