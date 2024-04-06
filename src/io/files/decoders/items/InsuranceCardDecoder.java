package io.files.decoders.items;

import io.files.decoders.StringDecoder;
import models.card.InsuranceCard;
import utils.converters.DateConverter;
import utils.converters.TypeConverter;

import java.util.Date;
import java.util.List;

public class InsuranceCardDecoder extends StringDecoder<InsuranceCard> {
    @Override
    public InsuranceCard decode(String s) {
        TypeConverter<Date> dateConverter = new DateConverter();

        List<String> attributes = parseAttributes(s);
        String id = attributes.get(0);
        String cardHolderId = attributes.get(1);
        String policyOwner = attributes.get(2);
        Date expDate = dateConverter.fromString(attributes.get(3));

        return new InsuranceCard(id, cardHolderId, policyOwner, expDate);
    }
}
