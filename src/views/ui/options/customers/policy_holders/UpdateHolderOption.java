package views.ui.options.customers.policy_holders;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.customers.policy_holder.PolicyHolderController;
import controllers.system.SystemControllerManager;
import views.ui.options.Option;

public class UpdateHolderOption extends Option {

    public UpdateHolderOption(SystemControllerManager controllers) {
        super("Update a Policy Holder");
        this.controllers = controllers;
    }

    @Override
    public void execute() {
        PolicyHolderController controller = controllers.getPolicyHolderController();
        controller.update();
    }
}
