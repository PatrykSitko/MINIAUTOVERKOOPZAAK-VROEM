package be.intecbrussel.patryksitko.dataAccessObject;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.intecbrussel.patryksitko.model.ModelDefaults;

public interface DaoDefaults<PK, OBJ extends ModelDefaults<PK, OBJ>> {

    // create
    default void add(OBJ target, String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(target);
            entityTransaction.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    // read
    default OBJ get(PK primaryKey, Class<OBJ> obj, String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        OBJ productline = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            productline = (OBJ) entityManager
                    .find(Class.forName(obj.getName()).getDeclaredConstructor().newInstance().getClass(), primaryKey);
            entityTransaction.commit();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
        return productline;
    }

    // read all
    default List<OBJ> getAll(Class<OBJ> obj, String persistenceUnitName, Optional<Integer> limit) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<OBJ> productline = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            productline = (List<OBJ>) entityManager.createQuery(
                    "SELECT * FROM " + obj.getSimpleName() + (limit.isPresent() ? " limit " + limit.get() : ""),
                    Class.forName(obj.getName()).getDeclaredConstructor().newInstance().getClass());
            entityTransaction.commit();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
        return productline;
    }

    // update
    default void update(OBJ targetToUpdate, OBJ updatedTarget, String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            OBJ productline = (OBJ) entityManager.find(updatedTarget.getClass(), targetToUpdate.getPrimaryKey());
            productline.update(updatedTarget);
            entityTransaction.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    // delete
    default void delete(OBJ target, String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(target);
            entityTransaction.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}