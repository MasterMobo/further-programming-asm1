package inputs;

import java.util.Scanner;

public abstract class DataReader<T> {
    // Read data from anywhere and convert it to type T
    private TypeConverter<T> converter;

    public DataReader() {
        converter = null;
    }

    public DataReader(TypeConverter<T> converter) {
        this.converter = converter;
    }

    public T read() {
        // Read the raw string and convert it to type T using the converter
        String s = readString();
        return converter.fromString(s);
    };

    // Reads and return the raw string
    // Needs to be implemented based on where you are getting the string from (e.g, console, file, UI)
    protected abstract String readString();
}
