package io.files.decoders;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.DataSeparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class StringDecoder<T> {
    public abstract T decode(String s);
    protected List<String> parseAttributes(String s) {
        return new ArrayList<>(Arrays.asList(s.split(DataSeparator.ATTRIBUTE)));
    }

    protected List<String> parseList(String s) {
        if (s.equals("EMPTY")) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(s.split(DataSeparator.LIST_ELEMENT)));
    }
}
