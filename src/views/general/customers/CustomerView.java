package views.general.customers;

import models.customer.Customer;
import views.general.AddView;
import views.general.ItemDisplayView;

public interface CustomerView extends AddView, ItemDisplayView<Customer> {
    String CUSTOMER_ID = "CUSTOMER_ID";
    String CUSTOMER_NAME = "CUSTOMER_NAME";
    String CARD_NUM = "CARD_NUM";

}
