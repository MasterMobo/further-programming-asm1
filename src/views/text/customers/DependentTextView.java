package views.text.customers;

import models.customer.Customer;
import models.customer.roles.dependent.Dependent;
import utils.console.ConsoleUtils;
import views.general.customers.DependentView;
import io.readers.ConsoleReader;
import io.readers.DataReader;
import views.system.ViewCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependentTextView extends CustomerTextView<Dependent> implements DependentView {
    @Override
    public void displayItem(Dependent customer) {
        if (customer == null) {
            System.out.println("Nothing to Show");
            return;
        };

        System.out.println("Dependent (" + customer.getId() + "): "
                + "\n\t Full Name: " + customer.getFullName()
                + "\n\t Insurance Card: " + customer.getInsuranceCardNumber()
        );
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

    @Override
    public Map<String, String> displayGetForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("Enter Dependent Id: ");
        data.put(DependentView.CUSTOMER_ID, reader.read());

        return data;
    }

    @Override
    public Map<String, String> displayGetManyForm() {
        // Don't need to enter anything
        return null;
    }

    @Override
    public void displayMany(List<Dependent> dependents) {
        for (Dependent dependent: dependents) {
            displayItem(dependent);
        }
    }


    @Override
    public Map<String, String> displayDeleteForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("Enter Dependent ID to Delete: ");
        data.put(DependentView.CUSTOMER_ID, reader.read());

        return data;
    }

    @Override
    public boolean displayDeleteConfirm() {
        DataReader reader = ConsoleReader.getInstance();
        ConsoleUtils.printYellow("This will also remove the Policy Holder's reference to this dependent.");
        ConsoleUtils.printYellow("Are you sure you want to delete this Dependent? (y/n)");
        ConsoleUtils.printRed("(This action is irreversible)");

        return reader.read().equalsIgnoreCase("y");
    }

    @Override
    public Map<String, String> displayUpdateForm() {
        Map<String, String> data = new HashMap<>();
        DataReader reader = ConsoleReader.getInstance();

        System.out.println("Enter Dependent ID to Update: ");
        data.put(DependentView.CUSTOMER_ID, reader.read());

        System.out.print("Enter Full Name: ");
        data.put(DependentView.CUSTOMER_NAME, reader.read());

        System.out.print("Enter Insurance Card Number: ");
        data.put(DependentView.CARD_NUM, reader.read());

        return data;
    }
}
