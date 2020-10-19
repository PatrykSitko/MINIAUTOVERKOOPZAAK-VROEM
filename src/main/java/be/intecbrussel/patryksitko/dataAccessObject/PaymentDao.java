package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Payment;

public abstract class PaymentDao implements DaoDefaults<String, Payment> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Payment payment) {
        this.add(payment, PERSISTENCE_UNIT_NAME);
    }

    public Payment get(String primaryKey) {
        return this.get(primaryKey, Payment.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Payment> getAll(Optional<Integer> limit) {
        return this.getAll(limit, Payment.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Payment paymentToUpdate, Payment updatedPayment) {
        this.update(paymentToUpdate, updatedPayment, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Payment payment) {
        this.delete(payment, PERSISTENCE_UNIT_NAME);
    }

}