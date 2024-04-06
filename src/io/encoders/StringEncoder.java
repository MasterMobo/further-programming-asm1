package io.encoders;

import io.Separator;

import java.util.List;

public abstract class StringEncoder<T> {
    public abstract String encode(T item);
    public String encodeList(List<String> list) {
        StringBuilder s = new StringBuilder();
        for (String item :list) {
            s.append(item);
            s.append(Separator.LIST_ELEMENT);
        }
        return s.toString();
    }
}
