package views.ui.options.claims;

import views.ui.options.Option;

public class InsuranceClaimOption extends Option {
    public InsuranceClaimOption() {
        super("Insurance Claims");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
