package utils.converters;

import java.util.Date;

public class DateConverter extends TypeConverter<Date> {

    @Override
    public Date fromString(String s) {
        return new Date(s.trim());
    }
}
