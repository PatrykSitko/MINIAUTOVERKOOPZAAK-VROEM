package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Orderdetail;

public abstract class OrderdetailDao implements DaoDefaults<Integer, Orderdetail> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Orderdetail orderDetail) {
        this.add(orderDetail, PERSISTENCE_UNIT_NAME);
    }

    public Orderdetail get(Integer primaryKey) {
        return this.get(primaryKey, Orderdetail.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Orderdetail> getAll(Optional<Integer> firstResult, Optional<Integer> maxResults) {
        return this.getAll(firstResult, maxResults, Orderdetail.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Orderdetail orderDetailToUpdate, Orderdetail updatedOrderdetail) {
        this.update(orderDetailToUpdate, updatedOrderdetail, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Orderdetail orderDetail) {
        this.delete(orderDetail, PERSISTENCE_UNIT_NAME);
    }

}