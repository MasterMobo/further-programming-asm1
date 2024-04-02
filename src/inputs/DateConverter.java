package inputs;

import java.util.Date;

public class DateConverter implements TypeConverter<Date> {

    @Override
    public Date fromString(String s) {
        return new Date(s);
    }
}
