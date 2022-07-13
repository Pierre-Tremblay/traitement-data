package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements DAO<Genre> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    @Override
    public void create(Genre objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (Exception e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un genre");
        }
    }

    @Override
    public void update(Genre objet) throws DALException {
// non utilisé
    }

    @Override
    public void delete(Genre objet) throws DALException {
// non utilisé
    }

    @Override
    public List<Genre> selectAll() throws DALException {
        ResultSet rs;
        List<Genre> genreList = new ArrayList<>();
        try {
            TypedQuery<Genre> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Genre a", Genre.class);
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la selection de genre");
        }
        return genreList;
    }

    @Override
    public Genre selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Genre a WHERE a.id = :id", Genre.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
