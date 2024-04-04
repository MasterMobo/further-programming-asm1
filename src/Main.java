import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.CustomerController;
import models.card.InsuranceCardMap;
import models.claims.InsuranceClaimMap;
import models.claims.InsuranceClaimStatus;
import models.customer.CustomerManager;
import models.customer.CustomerManagementSystem;
import models.customer.dependent.DependentMap;
import models.customer.holder.PolicyHolderMap;
import views.text.cards.InsuranceCardTextView;
import views.text.claims.InsuranceClaimTextView;
import views.text.customers.CustomerTextViewFactory;
import views.io.ConsoleReader;
import views.io.DataReader;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManagementSystem(new PolicyHolderMap(), new DependentMap());
        CustomerController controller = new CustomerController(customerManager, new CustomerTextViewFactory());
        InsuranceCardController cardController =  new InsuranceCardController(new InsuranceCardMap(), customerManager, new InsuranceCardTextView());
        InsuranceClaimController claimController = new InsuranceClaimController(new InsuranceClaimMap(), new InsuranceClaimTextView(), customerManager);

        DataReader reader = ConsoleReader.getInstance();
        String input = "";
        while (!input.equals("q")) {
            controller.createCustomer();
            cardController.createCard();
            claimController.createClaim();
            input = reader.read();
        }


    }
}