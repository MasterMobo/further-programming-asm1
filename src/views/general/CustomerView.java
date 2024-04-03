package views.general;

import models.customer.Customer;

import java.util.Map;

public interface CustomerView {
    String CUSTOMER_ID = "CUSTOMER_ID";
    String CUSTOMER_NAME = "CUSTOMER_NAME";
    String CARD_NUM = "CARD_NUM";

    void displayCustomer(Customer customer);
    Map<String, String> displayCreateCustomerForm();
    String displayRoleSelect();
    void displayError(String message);
}
