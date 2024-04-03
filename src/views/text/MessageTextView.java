package views.text;

import views.general.MessageView;
// TODO: Add colors if you have time
public abstract class MessageTextView extends MessageView {
    @Override
    public void displayMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void displayWarning(String s) {
        System.out.println(s);
    }

    @Override
    public void displayError(String s) {
        System.out.println(s);
    }
}
