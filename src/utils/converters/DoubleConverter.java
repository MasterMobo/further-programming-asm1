package utils.converters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */
public class DoubleConverter extends TypeConverter<Double>{

    @Override
    public Double fromString(String s) {
        return Double.parseDouble(s.trim());
    }
}
