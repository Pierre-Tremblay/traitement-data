package DAL;

import Entity.Film;

import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static DAL.ConnexionJPA.em;

public class FilmDAO implements DAO<Film> {
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
    public Film selectById(int id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Film a WHERE a.id = :id", Film.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
