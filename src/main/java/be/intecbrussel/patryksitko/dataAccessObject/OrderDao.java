package be.intecbrussel.patryksitko.dataAccessObject;

import be.intecbrussel.patryksitko.model.Order;

public abstract class OrderDao implements DaoDefaults<Integer, Order> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Order order) {
        this.add(order, PERSISTENCE_UNIT_NAME);
    }

    public Order get(Integer primaryKey) {
        return this.get(primaryKey, Order.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Order orderToUpdate, Order updatedOrder) {
        this.update(orderToUpdate, updatedOrder, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Order order) {
        this.delete(order, PERSISTENCE_UNIT_NAME);
    }

}