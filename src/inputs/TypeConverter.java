package inputs;

public interface TypeConverter<T> {
    // Convert Strings to object of type T
    T fromString(String s);
}
