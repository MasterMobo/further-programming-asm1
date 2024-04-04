import controllers.cards.InsuranceCardController;
import controllers.customers.CustomerController;
import models.card.InsuranceCardMap;
import models.customer.CustomerManager;
import models.customer.CustomerRoleList;
import models.customer.dependent.DependentMap;
import models.customer.holder.PolicyHolderMap;
import views.text.cards.InsuranceCardTextView;
import views.text.customers.CustomerTextViewFactory;
import views.ui.inputs.ConsoleReader;
import views.ui.inputs.DataReader;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerRoleList(new PolicyHolderMap(), new DependentMap());
        CustomerController controller = new CustomerController(customerManager, new CustomerTextViewFactory());
        InsuranceCardController cardController =  new InsuranceCardController(new InsuranceCardMap(), customerManager, new InsuranceCardTextView());

        DataReader reader = ConsoleReader.getInstance();
        String input = "";
        while (!input.equals("q")) {
            controller.createCustomer();
            cardController.createCard();
            input = reader.read();
        }



    }
}