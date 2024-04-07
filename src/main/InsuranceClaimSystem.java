package main;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.CustomerController;
import controllers.customers.dependents.DependentController;
import controllers.customers.policy_holder.PolicyHolderController;
import controllers.system.SystemControllerManager;
import controllers.system.SystemControllerStorage;
import io.files.FileManager;
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

public class InsuranceClaimSystem {
    // Highest-level class. Entry point of the program;


    public InsuranceClaimSystem() {
    }

    private SystemStorageManager initSystemStorage() {
        CustomerStorageManager customerStorageManager = new CustomerStorageMap();
        customerStorageManager.add(new PolicyHolderMapStorage());
        customerStorageManager.add(new DependentMapStorage());

        SystemStorageManager systemStorageManager = new SystemStorageMap();
        systemStorageManager.add(customerStorageManager);
        systemStorageManager.add(new InsuranceCardMapStorage());
        systemStorageManager.add(new InsuranceClaimMapStorage());
        return systemStorageManager;
    }

    private SystemViewManager initSystemView() {
        ViewFactory viewFactory = new TextViewFactory();
        SystemViewManager systemViewManager = new SystemViewMap();
        systemViewManager.add(viewFactory.createMessageView());
        systemViewManager.add(viewFactory.createPolicyHolderView());
        systemViewManager.add(viewFactory.createDependentView());
        systemViewManager.add(viewFactory.createInsuranceCardView());
        systemViewManager.add(viewFactory.createInsuranceClaimView());

        return systemViewManager;
    }

    private SystemControllerManager initSystemController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        CustomerController policyHolderController = new PolicyHolderController(systemStorageManager, systemViewManager);
        CustomerController dependentController = new DependentController(systemStorageManager, systemViewManager);
        InsuranceCardController cardController = new InsuranceCardController(systemStorageManager, systemViewManager);
        InsuranceClaimController claimController = new InsuranceClaimController(systemStorageManager, systemViewManager);

        SystemControllerManager systemControllerManager = new SystemControllerStorage();
        systemControllerManager.add(policyHolderController);
        systemControllerManager.add(dependentController);
        systemControllerManager.add(cardController);
        systemControllerManager.add(claimController);

        return systemControllerManager;
    }

    private OptionManager initSystemMenu(SystemControllerManager systemControllerManager) {
        OptionBuilder builder = new OptionBuilder(systemControllerManager);

        return new OptionTree(builder);
    }

    public void start() {

            SystemStorageManager systemStorageManager = initSystemStorage();

            FileManager.setSystemStorageManager(systemStorageManager);
            FileManager fileManager = FileManager.getInstance();
            systemStorageManager = fileManager.initializeDataFiles();
            FileManager.setSystemStorageManager(systemStorageManager);


            SystemViewManager systemViewManager = initSystemView();
            SystemControllerManager systemControllerManager = initSystemController(systemStorageManager, systemViewManager);
            OptionManager menu = initSystemMenu(systemControllerManager);
        try {
            menu.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong, please try again.");
            menu.execute();
        }
    }
}
