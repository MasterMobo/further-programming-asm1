package views.ui.options;

import controllers.system.SystemControllerManager;
import views.ui.options.cards.AddCardOption;
import views.ui.options.cards.InsuranceCardOption;
import views.ui.options.claims.*;
import views.ui.options.customers.*;

public class OptionBuilder {
    private SystemControllerManager controllers;

    public OptionBuilder() {
    }

    public OptionBuilder(SystemControllerManager controllers) {
        this.controllers = controllers;
    }

    public Option createRoot() {
        Option dependent = new DependentOption();
        dependent.addOption(new AddDependentOption(controllers));

        Option policyHolder = new PolicyHolderOption();
        policyHolder.addOption(new AddPolicyHolderOption(controllers));

        Option customer = new CustomerOption();
        customer.addOption(policyHolder);
        customer.addOption(dependent);

        Option cards = new InsuranceCardOption();
        cards.addOption(new AddCardOption(controllers));

        Option claims = new InsuranceClaimOption();
        claims.addOption(new AddClaimOption(controllers));
        claims.addOption(new GetSingleClaimOption(controllers));
        claims.addOption(new GetManyClaimOption(controllers));
        claims.addOption(new UpdateClaimOption(controllers));
        claims.addOption(new DeleteClaimOption(controllers));

        Option mainMenu = new MainMenu();
        mainMenu.addOption(customer);
        mainMenu.addOption(cards);
        mainMenu.addOption(claims);

        return mainMenu;
    }
}
