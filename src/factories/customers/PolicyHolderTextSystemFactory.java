package factories.customers;

import views.general.customers.CustomerView;
import views.text.customers.PolicyHolderTextView;

public class PolicyHolderTextSystemFactory extends PolicyHolderSystemFactory{
    @Override
    public CustomerView createView() {
        return new PolicyHolderTextView();
    }
}
