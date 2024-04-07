package io.files.decoders.storages;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.items.InsuranceCardDecoder;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;

public class CardStorageDecoder extends StorageDecoder<InsuranceCardStorage, InsuranceCard> {
    public CardStorageDecoder(InsuranceCardStorage storage) {
        super(new InsuranceCardDecoder(), storage);
    }
}
