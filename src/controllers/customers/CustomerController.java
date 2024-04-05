package controllers.customers;

import controllers.Controller;
import controllers.AddableController;
import controllers.customers.creators.CustomerCreator;
import models.customer.Customer;
import models.system.SystemManager;
import views.general.SystemView;

public abstract class CustomerController extends Controller<Customer> implements AddableController<Customer> {
    protected CustomerCreator creator;
    public CustomerController() {
        super();
    }

    public CustomerController(SystemManager systemManager, SystemView systemView) {
        this.systemManager = systemManager;
        this.systemView = systemView;
    }

    @Override
    public abstract Customer add();
}
