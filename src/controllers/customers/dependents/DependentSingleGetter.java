package controllers.customers.dependents;

import controllers.ControllerOperator;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.system.SystemStorageManager;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.system.SystemViewManager;

import java.util.Map;

public class DependentSingleGetter extends ControllerOperator {
    public DependentSingleGetter() {
        super();
    }

    public DependentSingleGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Dependent execute(Map<String, String> data) {
        MessageView message = systemViewManager.getMessageView();

        String id = data.get(DependentView.CUSTOMER_ID);
        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();
        if (!dependents.exists(id)) {
            message.displayError("Dependent does not exist");
        }

        return dependents.get(id);
    }
}
