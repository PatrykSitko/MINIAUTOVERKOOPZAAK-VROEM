package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Customer;

public abstract class CustomerDao implements DaoDefaults<Integer, Customer> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Customer customer) {
        this.add(customer, PERSISTENCE_UNIT_NAME);
    }

    public Customer get(Integer primaryKey) {
        return this.get(primaryKey, Customer.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Customer> getAll(Optional<Integer> limit) {
        return this.getAll(limit, Customer.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Customer customerToUpdate, Customer updatedCustomer) {
        this.update(customerToUpdate, updatedCustomer, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Customer customer) {
        this.delete(customer, PERSISTENCE_UNIT_NAME);
    }

}