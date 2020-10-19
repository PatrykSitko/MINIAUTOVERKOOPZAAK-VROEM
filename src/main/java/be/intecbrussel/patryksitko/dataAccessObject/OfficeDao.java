package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Office;

public abstract class OfficeDao implements DaoDefaults<String, Office> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Office office) {
        this.add(office, PERSISTENCE_UNIT_NAME);
    }

    public Office get(String primaryKey) {
        return this.get(primaryKey, Office.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Office> getAll(Optional<Integer> limit) {
        return this.getAll(limit, Office.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Office officeToUpdate, Office updatedOffice) {
        this.update(officeToUpdate, updatedOffice, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Office office) {
        this.delete(office, PERSISTENCE_UNIT_NAME);
    }

}