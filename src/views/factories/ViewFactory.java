package views.factories;

import views.general.InsuranceCardView;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;

public abstract class ViewFactory {
    public ViewFactory() {
    }

    // Abstract Factory Pattern
    public abstract MessageView createMessageView();
    public abstract PolicyHolderView createPolicyHolderView();
    public abstract DependentView createDependentView();
    public abstract InsuranceCardView createInsuranceCardView();
    public abstract InsuranceClaimView createInsuranceClaimView();
}
