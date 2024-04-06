package controllers.customers;

import controllers.Controller;
import controllers.AddableController;
import controllers.customers.creators.CustomerCreator;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

public abstract class CustomerController extends Controller<Customer> implements AddableController<Customer> {
    public CustomerController() {
        super();
    }

    public CustomerController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    @Override
    public abstract Customer add();
}
