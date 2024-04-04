package controllers.customers.creators;

import models.customer.Customer;
import models.customer.CustomerManager;
import models.customer.holder.PolicyHolder;
import views.general.CustomerView;

import java.util.Map;

public class PolicyHolderCreator extends CustomerCreator{

    public PolicyHolderCreator(CustomerManager customerManager, CustomerView customerView) {
        super(customerManager, customerView);
    }

    @Override
    public Customer create(Map<String, String> data) {
        String id = customerManager.generateAndAddId();
        String fullName = data.get(CustomerView.CUSTOMER_NAME);

        return new PolicyHolder(id, fullName);
    }
}
