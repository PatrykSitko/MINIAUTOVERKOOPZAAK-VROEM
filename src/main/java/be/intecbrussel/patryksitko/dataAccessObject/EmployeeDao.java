package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import be.intecbrussel.patryksitko.model.Employee;

public abstract class EmployeeDao implements DaoDefaults<Integer, Employee> {

    private static final String PERSISTENCE_UNIT_NAME = "classicmodels";

    public void add(Employee employee) {
        this.add(employee, PERSISTENCE_UNIT_NAME);
    }

    public Employee get(Integer primaryKey) {
        return this.get(primaryKey, Employee.class, PERSISTENCE_UNIT_NAME);
    }

    public List<Employee> getAll(Optional<Integer> limit) {
        return this.getAll(limit, Employee.class, PERSISTENCE_UNIT_NAME);
    }

    public void update(Employee employeeToUpdate, Employee updatedEmployee) {
        this.update(employeeToUpdate, updatedEmployee, PERSISTENCE_UNIT_NAME);
    }

    public void delete(Employee employee) {
        this.delete(employee, PERSISTENCE_UNIT_NAME);
    }

}