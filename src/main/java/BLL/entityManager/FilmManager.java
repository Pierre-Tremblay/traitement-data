package BLL;

import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.FilmDAO;
import Entity.Film;

import java.util.List;

public class FilmManager {
    public static volatile FilmManager instance;
    private static FilmDAO filmDAO;


    private FilmManager() {
        filmDAO = DAOFactory.getFilmDAO();
    }

    public static FilmManager getInstance() {
        if (instance == null) {
            synchronized (FilmManager.class) {
                if (instance == null) {
                    instance = new FilmManager();
                }
            }
        }
        return instance;
    }

    // Create
    public Film create(Film film) throws BLLException {
        try {
            if (filmDAO.selectById(film.getId()) == null && film.getId() != 0) {
                filmDAO.create(film);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'film", e);
        }
        return film;
    }
    // Read
    public List<Film> selectAll() throws BLLException {
        try {
            return filmDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des films", e);
        }
    }

    public Film selectById(long id) throws BLLException {
        try {
            return filmDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'film", e);
        }
    }
    //    Update
    public void update(Film film) throws BLLException {
        try {
            filmDAO.update(film);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'film", e);
        }
    }

    //    Delete
    public void delete(Film film) throws BLLException {
        try {
            filmDAO.delete(film);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'film", e);
        }
    }
}
