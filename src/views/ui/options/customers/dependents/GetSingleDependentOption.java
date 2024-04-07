package views.ui.options.customers.dependents;

import controllers.customers.dependents.DependentController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetSingleDependentOption extends Option {
    public GetSingleDependentOption(SystemControllerManager controllers) {
        super("Find a specify Dependent");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        DependentController controller = controllers.getDependentController();
        controller.get();
    }
}
