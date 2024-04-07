package views.ui.options.customers.dependents;

import controllers.customers.dependents.DependentController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetManyDependentOption extends Option {
    public GetManyDependentOption(SystemControllerManager controllers) {
        super("Get all Dependents");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        DependentController controller = controllers.getDependentController();
        controller.getMany();
    }
}
