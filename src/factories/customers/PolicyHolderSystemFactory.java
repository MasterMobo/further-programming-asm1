package factories.customers;

import controllers.customers.CustomerController;
import controllers.customers.PolicyHolderController;
import controllers.customers.creators.CustomerCreator;
import controllers.customers.creators.DependentCreator;
import controllers.customers.creators.PolicyHolderCreator;
import views.general.customers.CustomerView;

public abstract class PolicyHolderSystemFactory extends CustomerSystemFactory{
    @Override
    public CustomerController createController() {
        return new PolicyHolderController();
    }

    @Override
    public CustomerCreator createCreator() {
        return new PolicyHolderCreator();
    }

    public abstract CustomerView createView();
}
