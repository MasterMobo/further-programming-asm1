package controllers.customers.creators;

import models.customer.CustomerManager;
import models.customer.CustomerRoleCode;
import views.general.CustomerView;

public class CustomerCreatorFactory {
    // This class creates different CustomerCreators depending on what role is needed

    public CustomerCreatorFactory() {
    }

    public CustomerCreator createCreator() {
        return null;
    }

    public CustomerCreator createCreator(String role, CustomerManager customerManager, CustomerView customerView) {
        return switch (role) {
            case CustomerRoleCode.POLICYHOLDER -> new PolicyHolderCreator(customerManager, customerView);
            case CustomerRoleCode.DEPENDENT -> new DependentCreator(customerManager, customerView);
            default -> null;
        };
    }
}
