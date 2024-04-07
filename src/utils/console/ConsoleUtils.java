package utils.console;

public class ConsoleUtils {
    public static void clearScreen(){
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    public static void printBlue(String s) {
        System.out.println(ConsoleColors.BLUE + s + ConsoleColors.RESET);
    }
    public static void printYellow(String s) {
        System.out.println(ConsoleColors.YELLOW + s + ConsoleColors.RESET);
    }
    public static void printRed(String s) {
        System.out.println(ConsoleColors.RED + s + ConsoleColors.RESET);
    }
}
