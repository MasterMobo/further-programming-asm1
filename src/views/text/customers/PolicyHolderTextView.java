package views.text.customers;

import models.customer.Customer;
import views.io.ConsoleReader;
import views.io.DataReader;

import java.util.HashMap;
import java.util.Map;

public class PolicyHolderTextView extends CustomerTextView {

    @Override
    public void displayCustomer(Customer customer) {
        System.out.println("Policy Holder(" + customer.getId() + "): " + customer.getFullName());
    }

    @Override
    public Map<String, String> displayCreateCustomerForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.print("Enter Full Name: ");
        String name = reader.read();
        data.put(CUSTOMER_NAME, name);

        return data;
    }

}
