package controllers.cards;

import controllers.ControllerOperator;
import models.card.InsuranceCard;
import models.card.InsuranceCardStorage;
import models.customer.Customer;
import models.customer.CustomerStorageManager;
import models.customer.roles.dependent.Dependent;
import models.customer.roles.dependent.DependentStorage;
import models.customer.roles.holder.PolicyHolder;
import models.system.SystemStorageManager;
import views.general.InsuranceCardView;
import views.general.MessageView;
import views.system.SystemViewManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsuranceCardManyGetter extends ControllerOperator {
    public InsuranceCardManyGetter() {
        super();
    }

    public InsuranceCardManyGetter(SystemStorageManager systemStorageManager, SystemViewManager systemViewManager) {
        super(systemStorageManager, systemViewManager);
    }

    @Override
    public List<List<InsuranceCard>> execute(Map<String, String> data) {

        // First element is a list containing the customer's card. If no customer ID is provided, it is a list contains all the cards in the system.
        // Second element is a list containing the cards of the dependent (if this customer is a policyholder). This is empty if the customer is a dependent.
        List<List<InsuranceCard>> res = new ArrayList<>(2);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        MessageView message = systemViewManager.getMessageView();

        String customerId = data.get(InsuranceCardView.CARD_HOLDER);
        CustomerStorageManager customers = systemStorageManager.getCustomerStorageManager();
        InsuranceCardStorage cards = systemStorageManager.getCardStorage();

        // If no customer ID provided, return all cards
        if (customerId == null || customerId.equals("")) {
            res.set(0, cards.getAll());
            return res;
        }

        if (!customers.customerExists(customerId)) {
            message.displayError("Customer does not exist");
            return null;
        }

        Customer customer = customers.getCustomer(customerId);
        InsuranceCard customerCard = cards.get(customers.getCardNumber(customerId));

        // Add customer card
        List<InsuranceCard> customerCardList = new ArrayList<>();
        customerCardList.add(customerCard);
        res.set(0, customerCardList);

//        If customer is dependent, return result
        if (!(customer instanceof PolicyHolder)) {
            return res;
        }

        // Customer must be policyholder now
        DependentStorage dependents = customers.getDependentStorage();
        List<String> dependentIds = ((PolicyHolder) customer).getDependentIds();
        List<InsuranceCard> dependentCards = new ArrayList<>();

        // Retrieve dependent cards and add to result
        for (String dependentId: dependentIds) {
            String dependentCardNum = dependents.get(dependentId).getInsuranceCardNumber();

            dependentCards.add(cards.get(dependentCardNum));
        }

        res.set(1, dependentCards);

        return res;
    }
}
