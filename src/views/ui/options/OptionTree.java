package views.ui.options;

import io.files.FileManager;
import utils.console.ConsoleColors;
import utils.console.ConsoleUtils;
import utils.converters.IntegerConverter;
import utils.converters.TypeConverter;
import io.readers.ConsoleReader;
import io.readers.DataReader;

import java.util.Stack;

public class OptionTree implements OptionManager{
    private Option root;
    private Stack<Option> callStack;

    public OptionTree(OptionBuilder builder) {
        this.root = builder.createRoot();

        callStack = new Stack<>();
        callStack.add(root);
    }

    @Override
    public void execute() {
        DataReader reader = ConsoleReader.getInstance();

        Option current = callStack.peek();

        if (current.isLeaf()) {
            current.execute();

            System.out.println(ConsoleColors.BLUE + "Press ENTER to continue" + ConsoleColors.RESET);
            reader.read(); // Give buffer time for user to read before returning

            ConsoleUtils.clearScreen();
            returnToPrevious();
            execute();
            return;
        }

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
            if (!handleStringInput(input)) return;
        }

    }

    private void displayOption(Option option) {
        System.out.println("---" + option.getTitle() + "---");

        for (int i = 0; i < option.getChildren().size(); i++) {
            Option child = option.getChildren().get(i);
            System.out.println((i + 1) + " - " + child.getTitle());
        }

        System.out.println();
        System.out.println("---Other Options---");
        System.out.println("b - Back to Previous");
        System.out.println("r - Return to Main Menu");
        System.out.println("q - Quit Program (Save)");

        System.out.println("Enter your choice:");
    }

    private boolean handleStringInput(String s) {
        switch (s) {
            case "b" -> {
                returnToPrevious();
                execute();
                return true;
            }
            case "r" -> {
                reset();
                execute();
                return true;
            }
            case "q" -> {
                onQuit();
                return false;
            }
            default -> {
                System.out.println("Invalid Choice. Please try Again");
                execute();
                return true;
            }
        }
    }

    private void reset() {
        callStack.removeAllElements();
        callStack.add(root);
    }

    private boolean indexInvalid(int index) {
        Option current = callStack.peek();
        return (index < 0 || index >= current.getChildren().size());
    }

    private void returnToPrevious() {
        callStack.pop();
        if (callStack.isEmpty()) {
            reset();
            execute();
        }
    }

    private void onQuit() {
        FileManager fileManager = FileManager.getInstance();
        fileManager.save();
    }
}
