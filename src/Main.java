import views.ui.options.OptionManager;
import views.ui.options.OptionTree;

// TODO: Global (or at least entry level) try-catch so that program doesn't end when error
public class Main {
    public static void main(String[] args) {
//        CustomerStorageManager customerStorageManager = new CustomerStorageMap();
//        customerStorageManager.add(new PolicyHolderMapStorage());
//        customerStorageManager.add(new DependentMapStorage());
//
//        SystemStorageManager systemStorageManager = new SystemStorageMap();
//        systemStorageManager.add(customerStorageManager);
//        systemStorageManager.add(new InsuranceCardMapStorage());
//        systemStorageManager.add(new InsuranceClaimMapStorage());
//
//        ViewFactory viewFactory = new TextViewFactory();
//        SystemViewManager systemViewManager = new SystemViewMap();
//        systemViewManager.add(viewFactory.createMessageView());
//        systemViewManager.add(viewFactory.createPolicyHolderView());
//        systemViewManager.add(viewFactory.createDependentView());
//        systemViewManager.add(viewFactory.createInsuranceCardView());
//        systemViewManager.add(viewFactory.createInsuranceClaimView());
//
//        CustomerController policyHolderController = new PolicyHolderController(systemStorageManager, systemViewManager);
//        CustomerController dependentController = new DependentController(systemStorageManager, systemViewManager);
//        InsuranceCardController cardController = new InsuranceCardController(systemStorageManager, systemViewManager);
//        InsuranceClaimController claimController = new InsuranceClaimController(systemStorageManager, systemViewManager);
//
//        DataReader reader = ConsoleReader.getInstance();
//        String input = "";
//        while (!input.equals("q")) {
//            policyHolderController.add();
//            dependentController.add();
//
//            cardController.add();
//            cardController.add();
//
//            claimController.add();
//            claimController.add();
//
//            claimController.getMany();
//
//            input = reader.read();
//        }

        OptionManager menu = new OptionTree();
        menu.execute();
    }
}