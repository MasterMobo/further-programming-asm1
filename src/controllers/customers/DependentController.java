package controllers.customers;

import controllers.customers.creators.DependentCreator;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.general.SystemView;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentController extends CustomerController{
    public DependentController() {
        super();
        creator = new DependentCreator();
    }

    public DependentController(SystemStorageManager systemStorageManager, SystemView systemView) {
        super(systemStorageManager, systemView);
        creator = new DependentCreator(systemStorageManager, systemView);
    }

    @Override
    public Customer add() {
        DependentView dependentView = systemView.getDependentView();

        Map<String, String> data = dependentView.displayAddForm();

        Customer newCustomer = creator.create(data);

        // Customer can be null if creation failed
        if (newCustomer == null) return null;

        // Display newly added customer
        dependentView.displaySuccessAddMsg();
        dependentView.displayItem(newCustomer);

        return newCustomer;
    }
}
