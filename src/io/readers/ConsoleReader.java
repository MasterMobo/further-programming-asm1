package io.readers;

import java.util.Scanner;

public class ConsoleReader implements DataReader{
    // Reads data from the console as String
    // This class utilizes the Singleton Pattern to ensure no more than one Scanner is instantiated at once.

    private static ConsoleReader instance;
    private static Scanner scanner;

    private ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleReader getInstance() {
        if (instance == null) {
            instance = new ConsoleReader();
        }

        return instance;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
