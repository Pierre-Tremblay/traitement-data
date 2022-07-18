package DAL.entityDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Film;


public class FilmDAO implements DAO<Film> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Film objet) throws DALException {
        ConnexionJPA.getProperty().getTransaction().begin();
        ConnexionJPA.getProperty().persist(objet);
        ConnexionJPA.getProperty().getTransaction().commit();
    }
    
    @Override
    public void update(Film objet) throws DALException {

    }

    @Override
    public void delete(Film objet) throws DALException {

    }

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

    @Override
    public Film selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Film a WHERE a.id = :id", Film.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Film selectByIdentifiant(String identifiant) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Film a WHERE a.identifiant = :identifiant", Film.class).setParameter("identifiant", identifiant).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Film> selectFilmsByActor(String actor) throws DALException {
        try {
            return em.createQuery("SELECT DISTINCT f FROM Film f JOIN f.acteurs a JOIN FETCH f.genres WHERE a.identite = :acteur", Film.class).setParameter("acteur",actor).getResultList();
        }catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste de films pour un acteur donnée");
        }
    }
    public List<Film> selectFilmsByTwoDate(String firstYear, String secondYear) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f WHERE f.anneeSortie >= :firstYear AND f.anneeSortie <= :secondYear ORDER BY anneeSortie ASC", Film.class).setParameter("firstYear", firstYear).setParameter("secondYear", secondYear).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération des films entre deux années");
        }
    }
    public List<Film> selectFilmsBetweenTwoActors(String firstActeur, String secondActeur) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite = :firstActeur AND f.id IN (SELECT f.id FROM Film f JOIN f.acteurs a WHERE a.identite = :secondActeur ORDER BY f.anneeSortie ASC)", Film.class).setParameter("firstActeur", firstActeur).setParameter("secondActeur", secondActeur).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération des films des acteurs");
        }
    }
    public List<Film> selectFilmsByTwoDateWithActor(String firstYear, String secondYear, String acteur) throws DALException {
        try {
            return em.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a.identite=:acteur AND f.id IN (SELECT f.id FROM Film f WHERE f.anneeSortie BETWEEN :firstYear AND :secondYear)", Film.class).setParameter("acteur", acteur).setParameter("firstYear", firstYear).setParameter("secondYear", secondYear).getResultList();
        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème  lors de la récupération des films entre deux dates et un acteur");
        }
    }
}
