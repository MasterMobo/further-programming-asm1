package views.text.customers;

import models.customer.Customer;
import views.general.customers.PolicyHolderView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.Map;

public class PolicyHolderTextView extends CustomerTextView implements PolicyHolderView {

    @Override
    public void displayItem(Customer customer) {
        System.out.println("Policy Holder(" + customer.getId() + "): "
                            + "\n\t Full Name: " + customer.getFullName()
                            + "\n\t Insurance Card: " + customer.getInsuranceCardNumber()
        );
        System.out.println();
    }

    @Override
    public Map<String, String> displayAddForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("---Adding new Policy Holder---");

        System.out.print("Enter Full Name: ");
        String name = reader.read();
        data.put(CUSTOMER_NAME, name);

        return data;
    }

    @Override
    public String getId() {
        return ViewCode.POLICY_HOLDERS;
    }
}
