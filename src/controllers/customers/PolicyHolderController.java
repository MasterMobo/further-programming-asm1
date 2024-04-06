package controllers.customers;

import controllers.customers.creators.PolicyHolderCreator;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.general.SystemView;
import views.general.customers.PolicyHolderView;

import java.util.Map;

public class PolicyHolderController extends CustomerController{
    public PolicyHolderController() {
        creator = new PolicyHolderCreator();
    }

    public PolicyHolderController(SystemStorageManager systemStorageManager, SystemView systemView) {
        super(systemStorageManager, systemView);
        creator = new PolicyHolderCreator(systemStorageManager, systemView);
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
