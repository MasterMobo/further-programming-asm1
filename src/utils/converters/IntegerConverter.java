package utils.converters;

public class IntegerConverter extends TypeConverter<Integer>{

    @Override
    public Integer fromString(String s) {
        return Integer.parseInt(s.trim());
    }
}
