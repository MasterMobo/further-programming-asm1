package controllers.customers;

import controllers.customers.creators.PolicyHolderCreator;
import models.customer.Customer;
import models.system.SystemManager;
import views.general.MessageView;
import views.general.SystemView;
import views.general.customers.CustomerView;
import views.general.customers.PolicyHolderView;

import java.util.Map;

public class PolicyHolderController extends CustomerController{
    public PolicyHolderController() {
        creator = new PolicyHolderCreator();
    }

    public PolicyHolderController(SystemManager systemManager, SystemView systemView) {
        super(systemManager, systemView);
        creator = new PolicyHolderCreator(systemManager, systemView);
    }

    @Override
    public Customer add() {
        PolicyHolderView policyHolderView = systemView.getPolicyHolderView();

        Map<String, String> data = policyHolderView.displayAddForm();

        Customer newCustomer = creator.create(data);

        // Customer can be null if creation failed
        if (newCustomer == null) return null;

        // Display newly added customer
        policyHolderView.displaySuccessAddMsg();
        policyHolderView.displayItem(newCustomer);

        return newCustomer;
    }


}
