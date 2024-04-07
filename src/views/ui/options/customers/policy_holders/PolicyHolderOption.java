package views.ui.options.customers.policy_holders;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import views.ui.options.Option;

public class PolicyHolderOption extends Option {

    public PolicyHolderOption() {
        super("Policy Holder");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
