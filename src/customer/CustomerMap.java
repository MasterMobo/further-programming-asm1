package customer;

import id.IdGenerator;
import id.IdMap;
import id.PrefixIdGenerator;

public class CustomerMap extends IdMap<Customer> implements CustomerManager {

    public CustomerMap() {
        super();
        idGenerator = new PrefixIdGenerator("c", 7);
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
