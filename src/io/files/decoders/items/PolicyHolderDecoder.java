package io.files.decoders.items;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import io.files.decoders.StringDecoder;
import models.customer.roles.holder.PolicyHolder;

import java.util.List;

public class PolicyHolderDecoder extends StringDecoder<PolicyHolder> {
    @Override
    public PolicyHolder decode(String s) {
        List<String> attributes = parseAttributes(s);
        String id = attributes.get(0);
        String fullName = attributes.get(1);
        String cardNum = attributes.get(2);
        List<String> dependentIds = parseList(attributes.get(3));

        return new PolicyHolder(id, fullName, cardNum, dependentIds);
    }
}
