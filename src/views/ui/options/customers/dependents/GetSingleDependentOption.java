package views.ui.options.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.customers.dependents.DependentController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetSingleDependentOption extends Option {
    public GetSingleDependentOption(SystemControllerManager controllers) {
        super("Find a specific Dependent");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        DependentController controller = controllers.getDependentController();
        controller.get();
    }
}
