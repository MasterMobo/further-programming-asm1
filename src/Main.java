import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.CustomerController;
import controllers.customers.DependentController;
import controllers.customers.PolicyHolderController;
import models.card.InsuranceCardMapStorage;
import models.claims.InsuranceClaimMapStorage;
import models.customer.CustomerStorageManager;
import models.customer.CustomerStorageMap;
import models.customer.roles.dependent.DependentMapStorage;
import models.customer.roles.holder.PolicyHolderMapStorage;
import models.system.SystemStorageMap;
import models.system.SystemStorageManager;
import views.factories.TextViewFactory;
import views.factories.ViewFactory;
import views.general.SystemView;
import views.text.SystemTextView;
import views.io.ConsoleReader;
import views.io.DataReader;

// TODO: Global (or at least entry level) try-catch so that program doesn't end when error
public class Main {
    public static void main(String[] args) {
        CustomerStorageManager customerStorageManager = new CustomerStorageMap();
        customerStorageManager.add(new PolicyHolderMapStorage());
        customerStorageManager.add(new DependentMapStorage());

        SystemStorageManager systemStorageManager = new SystemStorageMap();
        systemStorageManager.add(customerStorageManager);
        systemStorageManager.add(new InsuranceCardMapStorage());
        systemStorageManager.add(new InsuranceClaimMapStorage());

        ViewFactory viewFactory = new TextViewFactory();
        SystemView systemView = new SystemTextView(viewFactory.createMessageView(), viewFactory.createPolicyHolderView(), viewFactory.createDependentView(), viewFactory.createInsuranceCardView(), viewFactory.createInsuranceClaimView());

        CustomerController policyHolderController = new PolicyHolderController(systemStorageManager, systemView);
        CustomerController dependentController = new DependentController(systemStorageManager, systemView);
        InsuranceCardController cardController = new InsuranceCardController(systemStorageManager, systemView);
        InsuranceClaimController claimController = new InsuranceClaimController(systemStorageManager, systemView);

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