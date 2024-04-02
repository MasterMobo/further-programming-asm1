package inputs;

public class StringConverter implements TypeConverter<String>{

    @Override
    public String fromString(String s) {
        return s;
    }
}
