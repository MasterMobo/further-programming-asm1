package views.factories;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import views.factories.ViewFactory;
import views.general.InsuranceCardView;
import views.general.InsuranceClaimView;
import views.general.MessageView;
import views.general.customers.DependentView;
import views.general.customers.PolicyHolderView;
import views.text.MessageTextView;
import views.text.cards.InsuranceCardTextView;
import views.text.claims.InsuranceClaimTextView;
import views.text.customers.DependentTextView;
import views.text.customers.PolicyHolderTextView;

public class TextViewFactory extends ViewFactory {
    public TextViewFactory() {
        super();
    }

    @Override
    public MessageView createMessageView() {
        return new MessageTextView();
    }

    @Override
    public PolicyHolderView createPolicyHolderView() {
        return new PolicyHolderTextView();
    }

    @Override
    public DependentView createDependentView() {
        return new DependentTextView();
    }

    @Override
    public InsuranceCardView createInsuranceCardView() {
        return new InsuranceCardTextView();
    }

    @Override
    public InsuranceClaimView createInsuranceClaimView() {
        return new InsuranceClaimTextView();
    }
}
