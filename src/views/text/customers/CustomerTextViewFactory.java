package views.text.customers;

import models.customer.CustomerRoleCode;
import views.general.customers.CustomerView;
import views.general.customers.CustomerViewFactory;

public class CustomerTextViewFactory extends CustomerViewFactory {
    @Override
    public CustomerView createView() {
        return new PolicyHolderTextView(); // Default view for customer will be policy-holder;
    }

    @Override
    public CustomerView createView(String role) {
        return switch (role) {
            case CustomerRoleCode.POLICYHOLDER -> new PolicyHolderTextView();
            case CustomerRoleCode.DEPENDENT -> new DependentTextView();
            default -> new PolicyHolderTextView();  // Default view for customer will be policy-holder
        };
    }
}
