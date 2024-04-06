package views.ui.options.claims;

import views.ui.options.Option;

public class AddClaimOption extends Option {
    public AddClaimOption() {
        super("Add a new Insurance Claim");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
