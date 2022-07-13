package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Acteur;
import Entity.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FilmDAO implements DAO<Film> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Film objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un film");
        }
    }

    @Override
    public void update(Film objet) throws DALException {

    }

    @Override
    public void delete(Film objet) throws DALException {

    }

    @Override
    public List<Film> selectAll() throws DALException {
        ResultSet rs;
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

}
