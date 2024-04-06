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
import views.system.SystemViewManager;
import views.io.ConsoleReader;
import views.io.DataReader;
import views.system.SystemViewMap;

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
        SystemViewManager systemViewManager = new SystemViewMap();
        systemViewManager.add(viewFactory.createMessageView());
        systemViewManager.add(viewFactory.createPolicyHolderView());
        systemViewManager.add(viewFactory.createDependentView());
        systemViewManager.add(viewFactory.createInsuranceCardView());
        systemViewManager.add(viewFactory.createInsuranceClaimView());

        CustomerController policyHolderController = new PolicyHolderController(systemStorageManager, systemViewManager);
        CustomerController dependentController = new DependentController(systemStorageManager, systemViewManager);
        InsuranceCardController cardController = new InsuranceCardController(systemStorageManager, systemViewManager);
        InsuranceClaimController claimController = new InsuranceClaimController(systemStorageManager, systemViewManager);

        DataReader reader = ConsoleReader.getInstance();
        String input = "";
        while (!input.equals("q")) {
            policyHolderController.add();
            dependentController.add();

            cardController.add();
            cardController.add();

            claimController.add();
            claimController.add();

            claimController.getMany();

            input = reader.read();
        }


    }
}