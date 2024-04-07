package views.ui.options.customers.policy_holders;

import controllers.customers.policy_holder.PolicyHolderController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class GetManyPolicyHolderOption extends Option {
    public GetManyPolicyHolderOption(SystemControllerManager controllers) {
        super("Get all Policy Holders");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        PolicyHolderController controller = controllers.getPolicyHolderController();
        controller.getMany();
    }
}
