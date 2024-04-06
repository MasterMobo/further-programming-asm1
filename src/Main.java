import controllers.cards.InsuranceCardController;
import controllers.claims.InsuranceClaimController;
import controllers.customers.CustomerController;
import controllers.customers.DependentController;
import controllers.customers.PolicyHolderController;
import controllers.system.SystemControllerManager;
import controllers.system.SystemControllerStorage;
import io.files.FileManager;
import main.InsuranceClaimSystem;
import models.card.InsuranceCardMapStorage;
import models.claims.InsuranceClaim;
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
        InsuranceClaimSystem system = new InsuranceClaimSystem();
        system.start();
    }
}