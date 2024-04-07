package views.general.customers;

import models.customer.Customer;
import views.general.operations.AddView;
import views.general.operations.DeleteView;
import views.general.operations.GetView;
import views.general.operations.ItemDisplayView;
import views.system.StorableView;

import java.util.List;

public interface CustomerView<T extends Customer> extends GetView, AddView, ItemDisplayView<T>, DeleteView, StorableView {
    String CUSTOMER_ID = "CUSTOMER_ID";
    String CUSTOMER_NAME = "CUSTOMER_NAME";
    String CARD_NUM = "CARD_NUM";
    void displayMany(List<T> customers);
}
