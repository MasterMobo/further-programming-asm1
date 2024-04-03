import controllers.CustomerController;
import models.customer.dependent.Dependent;
import models.customer.dependent.DependentMap;
import models.customer.holder.PolicyHolderMap;
import views.text.CustomerTextViewFactory;
import views.ui.inputs.ConsoleReader;
import views.ui.inputs.DataReader;
import views.ui.inputs.DoubleConverter;
import views.ui.inputs.TypeConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController(new PolicyHolderMap(), new DependentMap(), new CustomerTextViewFactory());
        DataReader reader = ConsoleReader.getInstance();
        String input = "";
        while (!input.equals("q")) {
            controller.createCustomer();
            input = reader.read();
        }



    }
}