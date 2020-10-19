package be.intecbrussel.patryksitko.dataAccessObject;

import be.intecbrussel.patryksitko.model.Customer;

public abstract class CustomerDao implements DaoDefaults<Integer, Customer> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Customer customer) {
        this.add(customer, PERSISTENCE_UNIT_NAME);
    }

    public Customer get(Integer primaryKey) {
        return this.get(primaryKey, PERSISTENCE_UNIT_NAME);
    }

    public void update(Customer customerToUpdate, Customer updatedCustomer) {
        this.update(customerToUpdate, updatedCustomer, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Customer customer) {
        this.delete(customer, PERSISTENCE_UNIT_NAME);
    }

}