package views.sorters;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

import models.customer.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomerSorter<T extends Customer> extends Sorter<T>{

    @Override
    public List<T> sort(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        temp.sort(Comparator.comparing(Customer::getFullName));
        return temp;
    }
}
