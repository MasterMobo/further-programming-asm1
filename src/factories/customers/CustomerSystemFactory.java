package factories.customers;

import controllers.customers.CustomerController;
import controllers.customers.creators.CustomerCreator;
import views.general.customers.CustomerView;

public abstract class CustomerSystemFactory {
    public abstract CustomerController createController();
    public abstract CustomerView createView();

    public abstract CustomerCreator createCreator();
}
