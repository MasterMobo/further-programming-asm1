package io.files.encoders.items;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.DataSeparator;
import io.files.encoders.StringEncoder;
import models.card.InsuranceCard;

public class InsuranceCardEncoder extends StringEncoder<InsuranceCard> {
    @Override
    public String encode(InsuranceCard item) {
        return item.getCardNumber() + DataSeparator.ATTRIBUTE
                + item.getCardHolderId() + DataSeparator.ATTRIBUTE
                + item.getPolicyOwner() + DataSeparator.ATTRIBUTE
                + encodeDate(item.getExpirationDate());
    }
}
