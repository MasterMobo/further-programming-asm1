package controllers.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.ControllerOperator;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.system.SystemStorageManager;
import views.system.SystemViewManager;

import java.util.List;
import java.util.Map;

public class DependentManyGetter extends ControllerOperator {
    public DependentManyGetter() {
        super();
    }

    public DependentManyGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public List<Dependent> execute(Map<String, String> data) {
        // No data is needed here
        DependentStorage dependents = systemStorageManager.getCustomerStorageManager().getDependentStorage();
        return dependents.getAll();
    }
}
