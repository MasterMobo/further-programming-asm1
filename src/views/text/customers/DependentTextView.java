package views.text.customers;

import models.customer.Customer;
import views.general.customers.DependentView;
import views.io.ConsoleReader;
import views.io.DataReader;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.Map;

public class DependentTextView extends CustomerTextView implements DependentView {
    @Override
    public void displayItem(Customer customer) {
        System.out.println("Dependent(" + customer.getId() + "): " + customer.getFullName());
    }

    @Override
    public Map<String, String> displayAddForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("---Adding new Dependent---");

        System.out.print("Enter Policy Holder ID: ");
        String dependsOn = reader.read();

        System.out.print("Enter Dependent Full Name: ");
        String name = reader.read();

        data.put(DEPENDS_ON, dependsOn);
        data.put(CUSTOMER_NAME, name);
        return data;
    }

    @Override
    public String getId() {
        return ViewCode.DEPENDENTS;
    }
}
