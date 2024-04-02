package inputs;

import java.util.Scanner;

public class ConsoleReader<T> extends DataReader<T>{
    private Scanner sc;

    public ConsoleReader() {
        super();
    }

    public ConsoleReader(TypeConverter<T> converter) {
        super(converter);
        sc = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return sc.nextLine();
    }
}
