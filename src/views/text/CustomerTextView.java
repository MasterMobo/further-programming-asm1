package views.text;

import models.customer.CustomerRoleCode;
import views.general.CustomerView;
import views.ui.inputs.ConsoleReader;
import views.ui.inputs.DataReader;

public abstract class CustomerTextView extends MessageTextView implements CustomerView {
    @Override
    public String displayRoleSelect() {
        DataReader reader = ConsoleReader.getInstance();
        System.out.println("Customer Role: ");
        System.out.println(CustomerRoleCode.POLICYHOLDER + " - Policy Holder");
        System.out.println(CustomerRoleCode.DEPENDENT + " - Dependent");
        return reader.read();
    }
}
