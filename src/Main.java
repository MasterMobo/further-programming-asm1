import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.claims.InsuranceClaimCreator;
import controllers.customers.CustomerController;
import controllers.customers.DependentController;
import controllers.customers.PolicyHolderController;
import models.card.InsuranceCardMap;
import models.claims.InsuranceClaimMap;
import models.claims.InsuranceClaimStatus;
import models.customer.CustomerManager;
import models.customer.CustomerManagementSystem;
import models.customer.dependent.DependentMap;
import models.customer.holder.PolicyHolderMap;
import models.system.ManagerSet;
import models.system.SystemManager;
import views.factories.TextViewFactory;
import views.factories.ViewFactory;
import views.general.SystemView;
import views.text.SystemTextView;
import views.text.cards.InsuranceCardTextView;
import views.text.claims.InsuranceClaimTextView;
import views.io.ConsoleReader;
import views.io.DataReader;

import java.util.Date;
// TODO: Global (or at least entry level) try-catch so that program doesn't end when error
public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManagementSystem(new PolicyHolderMap(), new DependentMap());
        SystemManager systemManager = new ManagerSet(customerManager, new InsuranceClaimMap(), new InsuranceCardMap());

        ViewFactory viewFactory = new TextViewFactory();
        SystemView systemView = new SystemTextView(viewFactory.createMessageView(), viewFactory.createPolicyHolderView(), viewFactory.createDependentView(), viewFactory.createInsuranceCardView(), viewFactory.createInsuranceClaimView());

        CustomerController policyHolderController = new PolicyHolderController(systemManager, systemView);
        CustomerController dependentController = new DependentController(systemManager, systemView);
        InsuranceCardController cardController = new InsuranceCardController(systemManager, systemView);
        InsuranceClaimController claimController = new InsuranceClaimController(systemManager, systemView);

        DataReader reader = ConsoleReader.getInstance();
        String input = "";
        while (!input.equals("q")) {
            policyHolderController.add();
            dependentController.add();
            cardController.add();
            claimController.add();

            input = reader.read();
        }


    }
}