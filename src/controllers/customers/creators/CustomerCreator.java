package controllers.customers.creators;

import controllers.ControllerOperator;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.Map;

public abstract class CustomerCreator extends ControllerOperator<Customer> {
    // This class deals with the creation logic for every customer role in the system.
    // Extend this class to customize how different roles are created.


    public CustomerCreator() {
        super();
    }

    public CustomerCreator(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    // Creates a new Customer.
    // Children classes need to override this method with their own creation logic.
    public abstract Customer execute(Map<String, String> data);

}
