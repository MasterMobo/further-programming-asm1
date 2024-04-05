package controllers.customers;

import controllers.customers.creators.DependentCreator;
import models.customer.Customer;
import models.system.SystemManager;
import views.general.MessageView;
import views.general.SystemView;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentController extends CustomerController{
    public DependentController() {
        super();
        creator = new DependentCreator();
    }

    public DependentController(SystemManager systemManager, SystemView systemView) {
        super(systemManager, systemView);
        creator = new DependentCreator(systemManager, systemView);
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
