package io.files.decoders;

import io.files.DataSeparator;

import java.util.ArrayList;
import java.util.List;

public abstract class StringDecoder<T> {
    public abstract T decode(String s);
    public List<String> parseAttributes(String s) {
        return List.of(s.split(DataSeparator.ATTRIBUTE));
    }

    public List<String> parseList(String s) {
        if (s.equals("EMPTY")) return new ArrayList<>();
        return List.of(s.split(DataSeparator.LIST_ELEMENT));
    }
}
