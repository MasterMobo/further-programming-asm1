package controllers.customers.creators;

import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class CustomerCreator {
    // This class deals with the creation logic for every customer role in the system.
    // Extend this class to customize how different roles are created.

    protected SystemStorageManager systemStorageManager;
    protected SystemViewManager systemViewManager;

    public CustomerCreator() {
    }

    public CustomerCreator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    // Creates a new Customer.
    // Children classes need to override this method with their own creation logic.
    public abstract Customer create(Map<String, String> data);

}
