package io.files.encoders;

import io.files.DataSeparator;

import java.util.List;

public abstract class StringEncoder<T> {
    public abstract String encode(T item);
    public String encodeList(List<String> list) {
        if (list.size() == 0) return "EMPTY";
        StringBuilder s = new StringBuilder();
        for (String item :list) {
            s.append(item);
            s.append(DataSeparator.LIST_ELEMENT);
        }
        return s.toString();
    }
}
