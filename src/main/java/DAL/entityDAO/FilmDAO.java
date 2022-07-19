package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe FilmDAO qui permet la gestion des films en BDD
 */
public class FilmDAO implements DAO<Film> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    /*
     * Création film en BDD
     */
    @Override
    public void create(Film objet) throws DALException {
        ConnexionJPA.getProperty().getTransaction().begin();
        ConnexionJPA.getProperty().persist(objet);
        ConnexionJPA.getProperty().getTransaction().commit();
    }

    /*
     * Mise à jour du film en BDD
     */
    @Override
    public void update(Film objet) throws DALException {
        //  non utilisé
    }

    /*
     * Suppression du film en BDD
     */
    @Override
    public void delete(Film objet) throws DALException {
        //  non utilisé
    }

    /*
     * Selection de l'ensemble des films en BDD
     */
    @Override
    public List<Film> selectAll() throws DALException {
        List<Film> filmList = new ArrayList<>();
        try {
            TypedQuery<Film> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Film a", Film.class);
            filmList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de films");
        }
        return filmList;
    }

    /*
     * Selection d'un film par son ID en BDD
     */
    @Override
    public Film selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Film a WHERE a.id = :id", Film.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Selection d'un film par son identifiant Imdb en BDD
     */
    public Film selectByIdentifiant(String identifiant) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Film a WHERE a.identifiant = :identifiant", Film.class).setParameter("identifiant", identifiant).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Selection d'un film par son acteur en BDD
     */
    public List<Film> selectFilmsByActor(String actor) throws DALException {
        try {
            return em.createQuery("SELECT DISTINCT f FROM Film f JOIN f.acteurs a JOIN FETCH f.genres WHERE a.identite = :acteur", Film.class).setParameter("acteur", actor).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de films pour un acteur donnée");
        }
    }

    /*
     * Selection de films entre deux dates
     */
    public List<Film> selectFilmsByTwoDate(String firstYear, String secondYear) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f WHERE f.anneeSortie >= :firstYear AND f.anneeSortie <= :secondYear ORDER BY anneeSortie ASC", Film.class).setParameter("firstYear", firstYear).setParameter("secondYear", secondYear).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération des films entre deux années");
        }
    }

    /*
     * Selection de films communs entre deux acteurs donnés
     */
    public List<Film> selectFilmsBetweenTwoActors(String firstActeur, String secondActeur) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :firstActeur AND f.id IN (SELECT f.id FROM Film f JOIN f.acteurs a WHERE a.identite = :secondActeur ORDER BY f.anneeSortie ASC)", Film.class).setParameter("firstActeur", firstActeur).setParameter("secondActeur", secondActeur).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération des films des acteurs");
        }
    }

    /*
     * Selection de films sortis entre deux années données avec un acteur donné
     */
    public List<Film> selectFilmsByTwoDateWithActor(String firstYear, String secondYear, String acteur) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite=:acteur AND f.id IN (SELECT f.id FROM Film f WHERE f.anneeSortie BETWEEN :firstYear AND :secondYear)", Film.class).setParameter("acteur", acteur).setParameter("firstYear", firstYear).setParameter("secondYear", secondYear).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème  lors de la récupération des films entre deux dates et un acteur");
        }
    }
}
