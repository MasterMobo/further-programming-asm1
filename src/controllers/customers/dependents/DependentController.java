package controllers.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.customers.CustomerController;
import controllers.customers.policy_holder.PolicyHolderDeleter;
import controllers.system.ControllerCode;
import models.customer.roles.dependent.Dependent;
import models.system.SystemStorageManager;
import views.general.customers.PolicyHolderView;
import views.system.SystemViewManager;
import views.general.customers.DependentView;

import java.util.List;
import java.util.Map;

public class DependentController extends CustomerController<Dependent> {
    public DependentController() {
        super();
    }

    public DependentController(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public Dependent add() {
        DependentView dependentView = systemViewManager.getDependentView();
        Map<String, String> data = dependentView.displayAddForm();
        DependentCreator creator = new DependentCreator(systemStorageManager, systemViewManager);

        return executeOperator(creator, data, dependentView);
    }

    @Override
    public String getId() {
        return ControllerCode.DEPENDENTS;
    }

    @Override
    public Dependent get() {
        DependentView dependentView = systemViewManager.getDependentView();
        Map<String, String> data = dependentView.displayGetForm();
        DependentSingleGetter singleGetter = new DependentSingleGetter(systemStorageManager, systemViewManager);

        return executeOperator(singleGetter, data, dependentView);
    }

    @Override
    public List<Dependent> getMany() {
        DependentView dependentView = systemViewManager.getDependentView();
        DependentManyGetter manyGetter = new DependentManyGetter(systemStorageManager, systemViewManager);

        List<Dependent> dependents = manyGetter.execute(null);
        dependentView.displayMany(dependents);
        return dependents;
    }

    @Override
    public Dependent delete() {
        DependentView dependentView = systemViewManager.getDependentView();
        Map<String, String> data = dependentView.displayDeleteForm();
        DependentDeleter deleter = new DependentDeleter(systemStorageManager, systemViewManager);

        return executeOperator(deleter, data, dependentView);
    }

    @Override
    public Dependent update() {
        DependentView dependentView = systemViewManager.getDependentView();
        Map<String, String> data = dependentView.displayUpdateForm();
        DependentUpdater updater = new DependentUpdater(systemStorageManager, systemViewManager);

        return executeOperator(updater, data, dependentView);
    }
}
