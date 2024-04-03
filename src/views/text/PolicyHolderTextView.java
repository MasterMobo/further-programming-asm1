package views.text;

import models.customer.Customer;
import models.customer.holder.PolicyHolder;
import views.ui.inputs.ConsoleReader;
import views.ui.inputs.DataReader;
import views.ui.inputs.StringConverter;

import java.util.HashMap;
import java.util.Map;

public class PolicyHolderTextView extends CustomerTextView {

    @Override
    public void displayCustomer(Customer customer) {
        System.out.println("Policy Holder(" + customer.getId() + "): " + customer.getFullName());

        // FIXME: yea...
//        for (Customer dependent: ((PolicyHolder) holder).getDependentIds()) {
//            System.out.println(dependent.toString());
//        }
    }

    @Override
    public Map<String, String> displayCreateCustomerForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("Enter Full Name: ");
        String name = reader.read();
        data.put(CUSTOMER_NAME, name);

        return data;
    }

}
