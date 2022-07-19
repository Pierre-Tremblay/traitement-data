package DAL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
/**
 * Classe ConnexionJPA qui permet la connexion à la BDD
 */
public class ConnexionJPA {

    /**
     * EntityManagerFactory
     */
    private static EntityManagerFactory emf;

    /**
     * EntityManager
     */
    static EntityManager em;

    /*
     * Méthode qui permet la connexion à la BDD
     */
    private static EntityManager loadDB() throws DALException{
        if(emf == null){
            emf = javax.persistence.Persistence.createEntityManagerFactory("jpa-connect");
            try{
                em = emf.createEntityManager();
            } catch (Exception e){
                throw new DALException("Une erreur est survenue durant la connexion avec entityManager");
            }
        }
        return em;
    }
    public static EntityManager getProperty() throws DALException{
        return loadDB();
    }
}