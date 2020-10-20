package be.intecbrussel.patryksitko;

import java.util.Optional;

import be.intecbrussel.patryksitko.dataAccessObject.EmployeeDao;
import be.intecbrussel.patryksitko.dataAccessObject.EmployeeDaoImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EmployeeDao cdao = new EmployeeDaoImpl();
        System.out.println(cdao.getAll(Optional.empty(), Optional.empty()));
    }
}
