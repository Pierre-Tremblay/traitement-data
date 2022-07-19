package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Acteur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ActeurDao qui permet la gestion des acteurs en BDD
 */
public class ActeurDAO implements DAO<Acteur> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    /*
     * Création acteur en BDD'
     */
    @Override
    public void create(Acteur objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un acteur");
        }
    }

    /*
     * Mise à jour de l'acteur en BDD
     */
    @Override
    public void update(Acteur objet) throws DALException {
        //  non utilisé
    }

    /*
     * Suppression de l'acteur en BDD
     */
    @Override
    public void delete(Acteur objet) throws DALException {
        //  non utilisé
    }

    /*
     * Selection de l'ensemble des acteurs en BDD
     */
    @Override
    public List<Acteur> selectAll() throws DALException {
        ResultSet rs;
        List<Acteur> acteurList = new ArrayList<>();
        try {
            TypedQuery<Acteur> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Acteur a", Acteur.class);
            acteurList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'acteurs");
        }
        return acteurList;
    }

    /*
     * Selection d'un acteur par son ID en BDD
     */
    @Override
    public Acteur selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Acteur a WHERE a.id = :id", Acteur.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Selection d'un acteur par son identifiant Imdb en BDD
     */
    public Acteur selectByIdentifiant(String identifiant) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Acteur a WHERE a.identifiant = :identifiant", Acteur.class).setParameter("identifiant", identifiant).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Selection d'un acteur par ses films en BDD
     */
    public List<Acteur> selectActorsByFilm(String filmName) throws DALException {
        try {
            return em.createQuery("SELECT DISTINCT a FROM Acteur a JOIN a.films f  LEFT JOIN fetch a.roles WHERE f.nom = :film", Acteur.class).setParameter("film", filmName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération des acteurs du film");
        }
    }

    /*
     * Selection d'acteurs qui ont en commun deux films en BDD
     */
    public List<Acteur> selectActorsBetweenTwoFilms(String firstFilm, String secondFilm) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Acteur a JOIN a.films f WHERE f.nom = :firstFilm AND a.id IN (SELECT a.id FROM Acteur a JOIN a.films f WHERE f.nom = :secondFilm )", Acteur.class).setParameter("firstFilm", firstFilm).setParameter("secondFilm", secondFilm).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème  lors de la récupération des films des deux acteurs");
        }
    }
}
