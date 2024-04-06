package views.ui.options;

import views.ui.options.claims.*;
import views.ui.options.customers.*;

public class OptionBuilder {
    public OptionBuilder() {
    }

    public Option createRoot() {
        Option dependent = new DependentOption();
        dependent.addOption(new AddDependentOption());

        Option policyHolder = new PolicyHolderOption();
        policyHolder.addOption(new AddPolicyHolderOption());

        Option customer = new CustomerOption();
        customer.addOption(policyHolder);
        customer.addOption(dependent);

        Option claims = new InsuranceClaimOption();
        claims.addOption(new AddClaimOption());
        claims.addOption(new GetSingleClaimOption());
        claims.addOption(new GetManyClaimOption());
        claims.addOption(new UpdateClaimOption());
        claims.addOption(new DeleteClaimOption());

        Option mainMenu = new MainMenu();
        mainMenu.addOption(customer);
        mainMenu.addOption(claims);

        return mainMenu;
    }
}
