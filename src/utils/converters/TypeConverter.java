package utils.converters;

public abstract class TypeConverter<T> {
    // Convert Strings to object of type T

    public abstract T fromString(String s);
}
