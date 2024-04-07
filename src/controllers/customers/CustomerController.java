package controllers.customers;

import controllers.*;
import models.customer.Customer;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

public abstract class CustomerController<T extends Customer> extends Controller<T> implements AddableController<T>, GettableController<T>, DeletableController<T>, UpdatableController<T> {
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
