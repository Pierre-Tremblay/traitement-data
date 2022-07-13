package BLL.entityManager;

import javax.persistence.EntityManagerFactory;

public class PersistenceManager {
    private static PersistenceManager instance;
    private final EntityManagerFactory emf;

    private PersistenceManager() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("jpa-connect");
    }

    public static PersistenceManager getInstance() {
        if (instance == null) {
            instance = new PersistenceManager();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}