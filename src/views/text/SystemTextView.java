package views.text;

import views.general.InsuranceCardView;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.SystemView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;

public class SystemTextView implements SystemView {
    private MessageView messageView;
    private PolicyHolderView policyHolderView;
    private DependentView dependentView;
    private InsuranceCardView insuranceCardView;
    private InsuranceClaimView insuranceClaimView;

    public SystemTextView() {
    }

    public SystemTextView(MessageView messageView, PolicyHolderView policyHolderView, DependentView dependentView, InsuranceCardView insuranceCardView, InsuranceClaimView insuranceClaimView) {
        this.messageView = messageView;
        this.policyHolderView = policyHolderView;
        this.dependentView = dependentView;
        this.insuranceCardView = insuranceCardView;
        this.insuranceClaimView = insuranceClaimView;
    }

    @Override
    public MessageView getMessageView() {
        return messageView;
    }

    @Override
    public PolicyHolderView getPolicyHolderView() {
        return policyHolderView;
    }

    @Override
    public DependentView getDependentView() {
        return dependentView;
    }

    @Override
    public InsuranceCardView getInsuranceCardView() {
        return insuranceCardView;
    }

    @Override
    public InsuranceClaimView getInsuranceClaimView() {
        return insuranceClaimView;
    }
}
