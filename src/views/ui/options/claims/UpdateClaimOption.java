package views.ui.options.claims;

import views.ui.options.Option;

public class UpdateClaimOption extends Option {
    public UpdateClaimOption() {
        super("Update an Insurance Claim");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
