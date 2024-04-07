package io.files.encoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.encoders.items.InsuranceCardEncoder;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;

public class CardStorageEncoder extends StorageEncoder<InsuranceCardStorage, InsuranceCard> {
    public CardStorageEncoder() {
        super(new InsuranceCardEncoder());
    }
}
