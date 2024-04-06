package views.ui.options;

import utils.console.ConsoleUtils;
import utils.converters.IntegerConverter;
import utils.converters.TypeConverter;
import views.io.ConsoleReader;
import views.io.DataReader;

import java.util.Stack;

public class OptionTree implements OptionManager{
    private Option root;
    private Stack<Option> callStack;

    public OptionTree() {
        OptionBuilder builder = new OptionBuilder();
        this.root = builder.createRoot();

        callStack = new Stack<>();
        callStack.add(root);
    }

    @Override
    public void execute() {
        Option current = callStack.peek();

        if (current.isLeaf()) {
            current.execute();
            callStack.pop();

            if (callStack.isEmpty()){
                reset();
            }

            execute();
            return;
        }

        DataReader reader = ConsoleReader.getInstance();
        TypeConverter<Integer> intConverter = new IntegerConverter();

        displayOption(current);

        String input = reader.read();

        ConsoleUtils.clearScreen();

        try {
            int index = intConverter.fromString(input) - 1;

            if (indexInvalid(index)) {
                System.out.println("Invalid Choice. Please try Again");
                execute();
                return;
            }

            current = current.getChildren().get(index);
            callStack.add(current);
            execute();

        } catch (IllegalArgumentException e) {
            if (!handleStringChoice(input)) {
                System.out.println("Invalid Choice. Please try Again");
                execute();
            }
        }

    }

    private void displayOption(Option option) {
        System.out.println("---" + option.getTitle() + "---");

        for (int i = 0; i < option.getChildren().size(); i++) {
            Option child = option.getChildren().get(i);
            System.out.println((i + 1) + " - " + child.getTitle());
        }

        System.out.println("b - Back to Previous");
        System.out.println("r - Return to Main Menu");

        System.out.println("Enter your choice:");
    }

    private boolean handleStringChoice(String s) {
        switch (s) {
            case "b" -> {
                callStack.pop();
                if (callStack.isEmpty()) {
                    reset();
                    return true;
                }
                execute();
                return true;
            }
            case "r" -> {
                reset();
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private void reset() {
        callStack.removeAllElements();
        callStack.add(root);
        execute();
    }

    private boolean indexInvalid(int index) {
        Option current = callStack.peek();
        return (index < 0 || index >= current.getChildren().size());
    }

}
