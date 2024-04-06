package controllers.customers;

import controllers.customers.creators.DependentCreator;
import controllers.system.ControllerCode;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;
import views.general.customers.DependentView;

import java.util.Map;

public class DependentController extends CustomerController{
    public DependentController() {
        super();
    }

    public DependentController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Customer add() {
        DependentView dependentView = systemViewManager.getDependentView();
        Map<String, String> data = dependentView.displayAddForm();
        DependentCreator creator = new DependentCreator(systemStorageManager, systemViewManager);

        return executeOperator(creator, data, dependentView);
    }

    @Override
    public String getId() {
        return ControllerCode.DEPENDENTS;
    }
}
