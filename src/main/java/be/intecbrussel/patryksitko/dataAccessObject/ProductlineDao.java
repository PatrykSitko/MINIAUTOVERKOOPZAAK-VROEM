package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;

import be.intecbrussel.patryksitko.model.Productline;

public abstract class ProductlineDao implements DaoDefaults<String, Productline> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Productline productline) {
        this.add(productline, PERSISTENCE_UNIT_NAME);
    }

    public Productline get(String primaryKey) {
        return this.get(primaryKey, Productline.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Productline> getAll() {
        return this.getAll(Productline.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Productline productlineToUpdate, Productline updatedProductline) {
        this.update(productlineToUpdate, updatedProductline, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Productline productLine) {
        this.delete(productLine, PERSISTENCE_UNIT_NAME);
    }
}