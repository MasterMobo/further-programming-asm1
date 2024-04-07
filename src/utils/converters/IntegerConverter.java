package utils.converters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */
public class IntegerConverter extends TypeConverter<Integer>{

    @Override
    public Integer fromString(String s) {
        return Integer.parseInt(s.trim());
    }
}
