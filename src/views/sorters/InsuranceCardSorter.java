package views.sorters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.card.InsuranceCard;
import models.claims.InsuranceClaim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsuranceCardSorter extends Sorter<InsuranceCard> {
    @Override
    public List<InsuranceCard> sort(List<InsuranceCard> list) {
        List<InsuranceCard> temp = new ArrayList<>(list);
        temp.sort(Comparator.comparing(InsuranceCard::getExpirationDate));
        return temp;
    }
}
