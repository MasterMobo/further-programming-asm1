package views.general.customers;

import models.customer.Customer;
import views.general.AddView;
import views.general.ItemDisplayView;
import views.system.StorableView;

public interface CustomerView extends AddView, ItemDisplayView<Customer>, StorableView {
    String CUSTOMER_ID = "CUSTOMER_ID";
    String CUSTOMER_NAME = "CUSTOMER_NAME";
    String CARD_NUM = "CARD_NUM";

}
