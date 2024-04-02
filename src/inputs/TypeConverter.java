package inputs;

public interface TypeConverter<T> {
    // Convert String to object of type T
    T fromString(String s);
}
