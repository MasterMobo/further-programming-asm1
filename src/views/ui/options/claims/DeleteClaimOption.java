package views.ui.options.claims;

import views.ui.options.Option;

public class DeleteClaimOption extends Option {
    public DeleteClaimOption() {
        super("Delete an Insurance Claim");
    }

    @Override
    public void execute() {
        System.out.println(title);
    }
}
