package controllers;

import models.customer.Customer;
import models.customer.CustomerRoleCode;
import models.customer.dependent.DependentManager;
import models.customer.holder.PolicyHolderManager;
import views.general.CustomerView;
import views.general.CustomerViewFactory;

import java.util.Map;

public class CustomerController {
    // Models
    private PolicyHolderManager policyHolders;
    private DependentManager dependents;

    // Views
    private CustomerViewFactory viewFactory;    // This factory decides which type of view we are using (e.g, text, GUI)
    private CustomerView customerView;

    // Helper classes
    private CustomerCreator customerCreator;
    private CustomerAdder customerAdder;

    // FIXME: This class is still too dependent on the two managers. What if we make more user roles? Do we add more to this class?
    public CustomerController(PolicyHolderManager policyHolders, DependentManager dependents, CustomerViewFactory viewFactory) {
        this.policyHolders = policyHolders;
        this.dependents = dependents;
        this.viewFactory = viewFactory;

        customerView = viewFactory.createView();
        customerCreator = new CustomerCreator(policyHolders, dependents, customerView);
        customerAdder = new CustomerAdder(policyHolders, dependents);
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

        // Create new Customer instance and add it to the manager
        Customer newCustomer = customerCreator.create(role, data);

        // Customer can be null if creation failed
        if (newCustomer == null) return null;

        newCustomer = customerAdder.add(role, newCustomer);

        // Display newly added customer
        customerView.displayCustomer(newCustomer);

        return newCustomer;
    };


}
