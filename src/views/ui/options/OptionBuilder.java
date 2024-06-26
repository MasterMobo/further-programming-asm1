package views.ui.options;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import controllers.system.SystemControllerManager;
import views.ui.options.cards.*;
import views.ui.options.claims.*;
import views.ui.options.customers.*;
import views.ui.options.customers.dependents.*;
import views.ui.options.customers.policy_holders.*;

public class OptionBuilder {
    private SystemControllerManager controllers;

    public OptionBuilder() {
    }

    public OptionBuilder(SystemControllerManager controllers) {
        this.controllers = controllers;
    }

    public Option createRoot() {
        Option policyHolder = new PolicyHolderOption();
        policyHolder.addOption(new AddPolicyHolderOption(controllers));
        policyHolder.addOption(new GetSinglePolicyHolderOption(controllers));
        policyHolder.addOption(new GetManyPolicyHolderOption(controllers));
        policyHolder.addOption(new UpdateHolderOption(controllers));
        policyHolder.addOption(new DeletePolicyHolderOption(controllers));

        Option dependent = new DependentOption();
        dependent.addOption(new AddDependentOption(controllers));
        dependent.addOption(new GetSingleDependentOption(controllers));
        dependent.addOption(new GetManyDependentOption(controllers));
        dependent.addOption(new GetSinglePolicyHolderOption(controllers));
        dependent.addOption(new UpdateDependentOption(controllers));
        dependent.addOption(new DeleteDependentOption(controllers));

        Option customer = new CustomerOption();
        customer.addOption(policyHolder);
        customer.addOption(dependent);

        Option cards = new InsuranceCardOption();
        cards.addOption(new AddCardOption(controllers));
        cards.addOption(new GetSingleCardOption(controllers));
        cards.addOption(new GetManyCardOption(controllers));
        cards.addOption(new UpdateCardOption(controllers));
        cards.addOption(new DeleteCardOption(controllers));

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
