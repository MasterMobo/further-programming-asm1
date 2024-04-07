package controllers.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolder;
import models.customer.roles.holder.PolicyHolderStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;
import views.system.SystemViewManager;

import java.util.Map;

public class DependentDeleter extends ControllerOperator {
    public DependentDeleter() {
    }

    public DependentDeleter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Object execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();
        DependentView dependentView = systemViewManager.getDependentView();

        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();
        String id = data.get(PolicyHolderView.CUSTOMER_ID);

        if (!dependents.exists(id)) {
            message.displayError("Dependent does not exist");
            return null;
        }

        if (!dependentView.displayDeleteConfirm()) {
            message.displayMessage("Delete canceled");
            return null;
        }

        PolicyHolderStorage policyHolders = systemStorageManager.getCustomerStorageManager().getPolicyHolderStorage();
        Dependent deleted = dependents.delete(id);

        // Remove dependent from policyHolder
        PolicyHolder originalHolder = policyHolders.getPolicyHolderOfDependent(id);
        if (originalHolder == null) {
            return deleted;
        }
        originalHolder.removeDependent(id);

        return deleted;
    }
}
