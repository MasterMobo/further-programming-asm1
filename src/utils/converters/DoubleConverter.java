package utils.converters;

public class DoubleConverter extends TypeConverter<Double>{

    @Override
    public Double fromString(String s) {
        return Double.parseDouble(s);
    }
}
