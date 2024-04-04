package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import views.general.CustomerView;

import java.util.Map;

public abstract class CustomerCreator {
    // This class deals with the creation logic for every customer role in the system.
    // Extend this class to customize how different roles are created.

    protected CustomerManager customerManager;  // The manager used to create the instances
    protected CustomerView customerView;    // View to display messages if needed.

    public CustomerCreator(CustomerManager customerManager, CustomerView customerView) {
        this.customerManager = customerManager;
        this.customerView = customerView;
    }

    // Creates a new Customer.
    // Children classes need to override this method with their own creation logic.
    public abstract Customer create(Map<String, String> data);

}
