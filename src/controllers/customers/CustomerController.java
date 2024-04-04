package controllers.customers;

import controllers.customers.creators.CustomerCreator;
import controllers.customers.creators.CustomerCreatorFactory;
import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.CustomerRoleCode;
import views.general.CustomerView;
import views.general.CustomerViewFactory;

import java.util.Map;

public class CustomerController {
    // Models
    private CustomerManager customerManager;
    // Views
    private CustomerViewFactory viewFactory;    // This factory decides which type of view we are using (e.g, text, GUI)
    private CustomerView customerView;

    // Helper classes
    private CustomerCreator customerCreator;    // Used to create customer of different roles
    private final CustomerCreatorFactory creatorFactory;  // Used to create CustomerCreator depending on role needed
    private CustomerAdder customerAdder;

    public CustomerController(CustomerManager customerManager, CustomerViewFactory viewFactory) {
        this.customerManager = customerManager;
        this.viewFactory = viewFactory;

        creatorFactory = new CustomerCreatorFactory();
        customerCreator = creatorFactory.createCreator();
        customerAdder = new CustomerAdder(customerManager);
        customerView = viewFactory.createView();
    }

    public Customer createCustomer() {
        // Get the role from user input
        String role = customerView.displayRoleSelect();

        if (!CustomerRoleCode.validRole(role)) {
            customerView.displayError("Invalid Role");
            return null;
        }

        // Switch out view depending on role (so that displayCreateCustomerForm() uses the correct implementation)
        customerView = viewFactory.createView(role);
        Map<String, String> data = customerView.displayCreateCustomerForm();

        // Switch out creator depending on role.
        customerCreator = creatorFactory.createCreator(role, customerManager, customerView);
        Customer newCustomer = customerCreator.create(data);

        // Customer can be null if creation failed
        if (newCustomer == null) return null;

        newCustomer = customerAdder.add(role, newCustomer);

        // Display newly added customer
        customerView.displayCustomer(newCustomer);

        return newCustomer;
    };


}
