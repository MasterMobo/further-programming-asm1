package views.ui.options.customers.dependents;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.customers.dependents.DependentController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class DeleteDependentOption extends Option {
    public DeleteDependentOption(SystemControllerManager controllers) {
        super("Delete a Dependent");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        DependentController controller = controllers.getDependentController();
        controller.delete();
    }
}
