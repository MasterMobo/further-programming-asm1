package inputs;

public class DoubleConverter implements TypeConverter<Double>{

    @Override
    public Double fromString(String s) {
        return Double.parseDouble(s);
    }
}
