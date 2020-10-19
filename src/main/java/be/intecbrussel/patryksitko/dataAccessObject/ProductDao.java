package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Product;

public abstract class ProductDao implements DaoDefaults<String, Product> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Product product) {
        this.add(product, PERSISTENCE_UNIT_NAME);
    }

    public Product get(String primaryKey) {
        return this.get(primaryKey, Product.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Product> getAll(Optional<Integer> limit) {
        return this.getAll(limit, Product.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Product productToUpdate, Product updatedProduct) {
        this.update(productToUpdate, updatedProduct, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Product product) {
        this.delete(product, PERSISTENCE_UNIT_NAME);
    }

}