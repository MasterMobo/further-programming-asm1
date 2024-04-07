package utils.converters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */
public class StringConverter extends TypeConverter<String>{

    @Override
    public String fromString(String s) {
        return s.trim();
    }
}
