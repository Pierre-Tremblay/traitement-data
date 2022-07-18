package BLL.entityManager;

import BLL.BLLException;
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
        	Film filmDB = filmDAO.selectByIdentifiant(film.getIdentifiant());
            if (filmDB == null) {
                filmDAO.create(film);
            } else {
            	film.setId(filmDB.getId());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion du film", e);
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
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de films", e);
        }
    }
    public List<Film> getFilmsByActor(String name) throws BLLException {
        try {
            return  filmDAO.selectFilmsByActor(name);
        }catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des filsm de l'acteur");
        }
    }
    public List<Film> selectFilmsByTwoDate(String firstYear, String secondYear) throws BLLException {
        try {
            return filmDAO.selectFilmsByTwoDate(firstYear, secondYear);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération du film", e);
        }
    }
    public List<Film> selectFilmsBetweenTwoActors(String firstActeur, String secondActeur) throws BLLException {
        try {
            return filmDAO.selectFilmsBetweenTwoActors(firstActeur, secondActeur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération du film", e);
        }
    }
    public List<Film> selectFilmsByTwoDateWithActor(String firstYear, String secondYear, String acteur) throws BLLException {
        try {
            return filmDAO.selectFilmsByTwoDateWithActor(firstYear, secondYear, acteur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème  lors de la récupération des films entre deux dates et un acteur");
        }
    }
}
