package views.text;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import utils.console.ConsoleColors;
import views.general.MessageView;
import views.system.ViewCode;

public class MessageTextView implements MessageView {
    @Override
    public void displayMessage(String s) {
        System.out.println(ConsoleColors.BLUE + s + ConsoleColors.RESET);
    }

    @Override
    public void displayError(String s) {
        System.out.println(ConsoleColors.RED + s + ConsoleColors.RESET);
    }

    @Override
    public void displayWarning(String s) {
        System.out.println(ConsoleColors.YELLOW + s + ConsoleColors.RESET);
    }

    @Override
    public String getId() {
        return ViewCode.MESSAGE;
    }
}
