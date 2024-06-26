package views.text.customers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.Customer;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.holder.PolicyHolder;
import utils.console.ConsoleColors;
import utils.console.ConsoleUtils;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.sorters.CustomerSorter;
import views.sorters.Sorter;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyHolderTextView extends CustomerTextView<PolicyHolder> implements PolicyHolderView {

    @Override
    public void displayItem(PolicyHolder customer) {
        if (customer == null) {
            System.out.println("Nothing to Show");
            return;
        }

        System.out.println("Policy Holder(" + customer.getId() + "): "
                            + "\n\t Full Name: " + customer.getFullName()
                            + "\n\t Insurance Card: " + customer.getInsuranceCardNumber()
        );
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

    @Override
    public Map<String, String> displayGetForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();
        System.out.println("Enter Policy Holder Id: ");
        data.put(PolicyHolderView.CUSTOMER_ID, reader.read());

        return data;
    }

    @Override
    public Map<String, String> displayGetManyForm() {
        // We don't need to put anything in
        return null;
    }

    @Override
    public void displayWithDependents(List<Object> res) {
        PolicyHolder policyHolder = (PolicyHolder) res.get(0);
        displayItem(policyHolder);

        List<Dependent> dependents = (List<Dependent>) res.get(1);
        if (dependents.size() == 0) {
            return;
        }

        System.out.println("---Dependents---");
        Sorter<Dependent> sorter = new CustomerSorter<>();
        for (Dependent dependent: sorter.sort(dependents)) {
            System.out.println("Dependent(" + dependent.getId() + "): " + dependent.getFullName());
        }

    }

    @Override
    public void displayMany(List<PolicyHolder> customers) {
        Sorter<PolicyHolder> sorter = new CustomerSorter<>();
        for (PolicyHolder ph: sorter.sort(customers)) {
            displayItem(ph);
        }
    }

    @Override
    public Map<String, String> displayDeleteForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();
        System.out.println("Enter Policy Holder ID to Delete: ");
        data.put(PolicyHolderView.CUSTOMER_ID, reader.read());

        return data;
    }

    @Override
    public boolean displayDeleteConfirm() {
        DataReader reader = ConsoleReader.getInstance();
        ConsoleUtils.printYellow("Are you sure you want to delete this Policy Holder? (y/n)");
        ConsoleUtils.printRed("(This action is irreversible)");

        return reader.read().equalsIgnoreCase("y");
    }

    @Override
    public Map<String, String> displayUpdateForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("Enter Policy Holder ID to Update: ");
        data.put(DependentView.CUSTOMER_ID, reader.read());

        System.out.print("Enter Full Name: ");
        data.put(DependentView.CUSTOMER_NAME, reader.read());

        System.out.print("Enter Insurance Card Number: ");
        data.put(DependentView.CARD_NUM, reader.read());
        return data;
    }
}
