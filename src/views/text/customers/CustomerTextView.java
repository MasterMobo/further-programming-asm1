package views.text.customers;

import models.customer.CustomerRoleCode;
import views.general.CustomerView;
import views.ui.inputs.ConsoleReader;
import views.ui.inputs.DataReader;

public abstract class CustomerTextView implements CustomerView {
    @Override
    public String displayRoleSelect() {
        DataReader reader = ConsoleReader.getInstance();
        System.out.println("Enter Customer Role: ");
        System.out.println("\t" + CustomerRoleCode.POLICYHOLDER + " - Policy Holder");
        System.out.println("\t" + CustomerRoleCode.DEPENDENT + " - Dependent");
        return reader.read();
    }

    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void displayError(String s) {
        System.out.println(s);
    }
}
