package customer;

import maps.IdMap;

public class CustomerMap extends IdMap<Customer> implements CustomerMapOperations{
    public CustomerMap() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        idToItem.forEach((id, item) -> {
            s.append(item.toString());
        });
        return s.toString();
    }


}
