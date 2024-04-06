import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.CustomerController;
import controllers.customers.DependentController;
import controllers.customers.PolicyHolderController;
import controllers.system.SystemControllerManager;
import controllers.system.SystemControllerStorage;
import models.card.InsuranceCardMapStorage;
import models.claims.InsuranceClaimMapStorage;
import models.customer.CustomerStorageManager;
import models.customer.CustomerStorageMap;
import models.customer.roles.dependent.DependentMapStorage;
import models.customer.roles.holder.PolicyHolderMapStorage;
import models.system.SystemStorageManager;
import models.system.SystemStorageMap;
import views.factories.TextViewFactory;
import views.factories.ViewFactory;
import views.system.SystemViewManager;
import views.system.SystemViewMap;
import views.ui.options.OptionBuilder;
import views.ui.options.OptionManager;
import views.ui.options.OptionTree;

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

        SystemControllerManager systemControllerManager = new SystemControllerStorage();
        systemControllerManager.add(policyHolderController);
        systemControllerManager.add(dependentController);
        systemControllerManager.add(cardController);
        systemControllerManager.add(claimController);

        OptionBuilder builder = new OptionBuilder(systemControllerManager);
        OptionManager menu = new OptionTree(builder);
        menu.execute();
    }
}