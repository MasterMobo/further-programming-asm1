package io.files.decoders.items;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.StringDecoder;
import models.claims.InsuranceClaim;
import models.claims.InsuranceClaimStatus;
import utils.converters.DateConverter;
import utils.converters.DoubleConverter;
import utils.converters.TypeConverter;

import java.util.Date;
import java.util.List;

public class InsuranceClaimDecoder extends StringDecoder<InsuranceClaim> {
    @Override
    public InsuranceClaim decode(String s) {
        TypeConverter<Date> dateConverter = new DateConverter();
        TypeConverter<Double> doubleConverter = new DoubleConverter();

        List<String> attributes = parseAttributes(s);
        String id = attributes.get(0);
        String insuredId = attributes.get(1);
        String cardNum = attributes.get(2);
        double claimAmount = doubleConverter.fromString(attributes.get(3));
        InsuranceClaimStatus status = InsuranceClaimStatus.valueOf(attributes.get(4));
        Date claimDate = dateConverter.fromString(attributes.get(5));
        Date examDate = dateConverter.fromString(attributes.get(6));
        String bankInfo = attributes.get(7);
        List<String> documents = parseList(attributes.get(8));

        return new InsuranceClaim(id, claimDate, insuredId, cardNum, examDate, documents, claimAmount, status, bankInfo);
    }
}
