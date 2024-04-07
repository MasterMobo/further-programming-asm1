package utils.converters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */
public abstract class TypeConverter<T> {
    // Convert Strings to object of type T

    public abstract T fromString(String s);
}
