package io.files.decoders.items;

import io.files.decoders.StringDecoder;
import models.customer.roles.dependent.Dependent;

import java.util.List;

public class DependentDecoder extends StringDecoder<Dependent> {
    @Override
    public Dependent decode(String s) {
        List<String> attributes = parseAttributes(s);
        String id = attributes.get(0);
        String fullName = attributes.get(1);
        String cardNum = attributes.get(2);

        return new Dependent(id, fullName, cardNum);
    }
}
