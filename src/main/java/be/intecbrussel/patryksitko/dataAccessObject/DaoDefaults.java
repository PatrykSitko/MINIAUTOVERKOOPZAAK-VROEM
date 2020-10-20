package be.intecbrussel.patryksitko.dataAccessObject;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

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
            productline = (OBJ) entityManager.find(obj, primaryKey);
            entityTransaction.commit();
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
    default List<OBJ> getAll(Optional<Integer> firstResult, Optional<Integer> maxResults, Class<OBJ> obj,
            String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<OBJ> productline = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Session session = entityManager.unwrap(Session.class);
            String tableName = session.getMetamodel().entity(obj).getName();
            Query query = entityManager.createQuery("FROM " + tableName, obj);
            if (firstResult.isPresent()) {
                query.setFirstResult(firstResult.get());
            }
            if (maxResults.isPresent()) {
                query.setMaxResults(maxResults.get());
            }
            productline = query.getResultList();
            entityTransaction.commit();
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