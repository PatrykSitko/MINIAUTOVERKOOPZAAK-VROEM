package be.intecbrussel.patryksitko.dataAccessObject;

import be.intecbrussel.patryksitko.model.Employee;

public abstract class EmployeeDao implements DaoDefaults<Integer, Employee> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Employee employee) {
        this.add(employee, PERSISTENCE_UNIT_NAME);
    }

    public Employee get(Integer primaryKey) {
        return this.get(primaryKey, PERSISTENCE_UNIT_NAME);
    }

    public void update(Employee employeeToUpdate, Employee updatedEmployee) {
        this.update(employeeToUpdate, updatedEmployee, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Employee employee) {
        this.delete(employee, PERSISTENCE_UNIT_NAME);
    }

}