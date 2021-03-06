package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Realisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe RealisateurDAO qui permet la gestion des réalisateurs en BDD
 */
public class RealisateurDAO implements DAO<Realisateur> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    /*
     * Création réalisateur en BDD
     */
    @Override
    public void create(Realisateur objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un realisateur");
        }
    }

    /*
     * Mise à jour du réalisateur en BDD
     */
    @Override
    public void update(Realisateur objet) throws DALException {
        //  non utilisé
    }

    /*
     * Suppression du réalisateur en BDD
     */
    @Override
    public void delete(Realisateur objet) throws DALException {
        //  non utilisé
    }

    /*
     * Selection de l'ensemble des réalisateurs en BDD
     */
    @Override
    public List<Realisateur> selectAll() throws DALException {
        ResultSet rs;
        List<Realisateur> realisateurList = new ArrayList<>();
        try {
            TypedQuery<Realisateur> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Realisateur a", Realisateur.class);
            realisateurList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'realisateurs");
        }
        return realisateurList;
    }

    /*
     * Selection d'un réalisateur par son ID en BDD
     */
    @Override
    public Realisateur selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Realisateur a WHERE a.id = :id", Realisateur.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Selection d'un réalisateur par son nom en BDD
     */
    public Realisateur selectByIdentite(String identite) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Realisateur a WHERE a.identite = :identite", Realisateur.class).setParameter("identite", identite).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
