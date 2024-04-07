package controllers.customers;

import controllers.Controller;
import controllers.AddableController;
import controllers.DeletableController;
import controllers.GettableController;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

public abstract class CustomerController<T extends Customer> extends Controller<T> implements AddableController<T>, GettableController<T>, DeletableController<T> {
    public CustomerController() {
        super();
    }

    public CustomerController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        this.systemStorageManager = systemStorageManager;
        this.systemViewManager = systemViewManager;
    }

    @Override
    public abstract T add();
}
