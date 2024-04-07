package utils.converters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import java.util.Date;

public class DateConverter extends TypeConverter<Date> {

    @Override
    public Date fromString(String s) {
        return new Date(s.trim());
    }
}
