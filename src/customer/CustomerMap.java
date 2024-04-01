package customer;

import id.IdMap;

public class CustomerMap extends IdMap<Customer> implements CustomerManager {
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

    @Override
    public void add(Customer item) {
        super.add(item);
    }

    @Override
    public boolean exists(String id) {
        return super.exists(id);
    }
}
