package io.files.encoders;

import io.files.DataSeparator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class StringEncoder<T> {
    public abstract String encode(T item);
    protected String encodeList(List<String> list) {
        if (list.size() == 0) return "EMPTY";
        StringBuilder s = new StringBuilder();
        for (String item :list) {
            s.append(item);
            s.append(DataSeparator.LIST_ELEMENT);
        }
        return s.toString();
    }

    protected String encodeDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(date);
    }
}
