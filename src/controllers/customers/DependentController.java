package controllers.customers;

import controllers.customers.creators.DependentCreator;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentController extends CustomerController{
    public DependentController() {
        super();
        creator = new DependentCreator();
    }

    public DependentController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
        creator = new DependentCreator(systemStorageManager, systemViewManager);
    }

    @Override
    public Customer add() {
        DependentView dependentView = systemViewManager.getDependentView();

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
