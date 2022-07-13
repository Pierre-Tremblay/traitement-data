package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.GenreDAO;
import Entity.Genre;

import java.util.List;

public class GenreManager {
    public static volatile GenreManager instance;
    private static GenreDAO genreDAO;


    private GenreManager() {
        genreDAO = DAOFactory.getGenreDAO();
    }

    public static GenreManager getInstance() {
        if (instance == null) {
            synchronized (GenreManager.class) {
                if (instance == null) {
                    instance = new GenreManager();
                }
            }
        }
        return instance;
    }

    // Create
    public Genre create(Genre genre) throws BLLException {
//        try {
//            if (genreDAO.selectById(genre.getId()) == null && genre.getId() != 0) {
//                genreDAO.create(genre);
//            } else {
//                return null;
//            }
//        } catch (DALException e) {
//            throw new BLLException("Erreur lors de l'insertion de genre", e);
//        }
//        return genre;
        return null;
    }

    // Read
    public List<Genre> selectAll() throws BLLException {
        try {
            return genreDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des genres", e);
        }
    }

    public Genre selectById(long id) throws BLLException {
        try {
            return genreDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de genre", e);
        }
    }

    //    Update
    public void update(Genre genre) throws BLLException {
        try {
            genreDAO.update(genre);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de genre", e);
        }
    }

    //    Delete
    public void delete(Genre genre) throws BLLException {
        try {
            genreDAO.delete(genre);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de genre", e);
        }
    }
}
