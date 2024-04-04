package views.general;

import models.customer.Customer;
import models.customer.CustomerRoleManager;

import java.util.List;
import java.util.Map;

public interface CustomerView {
    String CUSTOMER_ID = "CUSTOMER_ID";
    String CUSTOMER_NAME = "CUSTOMER_NAME";
    String CARD_NUM = "CARD_NUM";

    void displayCustomer(Customer customer);
    Map<String, String> displayCreateCustomerForm();
    String displayRoleSelect();

    // TODO: Messages should be in a separate class
    void displayMessage(String s);
    void displayError(String s);
}
