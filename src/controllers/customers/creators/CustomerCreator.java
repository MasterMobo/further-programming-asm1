package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.system.SystemManager;
import views.general.SystemView;
import views.general.customers.CustomerView;

import java.util.Map;

public abstract class CustomerCreator {
    // This class deals with the creation logic for every customer role in the system.
    // Extend this class to customize how different roles are created.

    protected SystemManager systemManager;
    protected SystemView systemView;

    public CustomerCreator() {
    }

    public CustomerCreator(SystemManager systemManager, SystemView systemView) {
        this.systemManager = systemManager;
        this.systemView = systemView;
    }

    // Creates a new Customer.
    // Children classes need to override this method with their own creation logic.
    public abstract Customer create(Map<String, String> data);

}
