package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.FilmDAO;
import Entity.Film;

import java.util.List;
/**
 * Classe FilmManager qui permet la gestion des requêtes concernant les films
 */
public class FilmManager {
    public static volatile FilmManager instance;
    private static FilmDAO filmDAO;

    /*
     * Constructeur de la classe FilmManager
     */
    private FilmManager() {
        filmDAO = DAOFactory.getFilmDAO();
    }

    /*
     * Retour de l'instance de la classe FilmManager
     */
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

    /*
     * Création du film
     */
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
    /*
     * Selection de l'ensemble des films
     */
    public List<Film> selectAll() throws BLLException {
        try {
            return filmDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des films", e);
        }
    }

    /*
     * Selection d'un film par son ID
     */
    public Film selectById(long id) throws BLLException {
        try {
            return filmDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'film", e);
        }
    }

    /*
     * Mise à jour du film
     */
    public void update(Film film) throws BLLException {
        try {
            filmDAO.update(film);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'film", e);
        }
    }

    /*
     * Suppression du film
     */
    public void delete(Film film) throws BLLException {
        try {
            filmDAO.delete(film);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de films", e);
        }
    }
    /*
     * Selection de films par un acteur
     */
    public List<Film> getFilmsByActor(String name) throws BLLException {
        try {
            return  filmDAO.selectFilmsByActor(name);
        }catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des filsm de l'acteur");
        }
    }
    /*
    * Selection de films sortis entre 2 années données
     */
    public List<Film> selectFilmsByTwoDate(String firstYear, String secondYear) throws BLLException {
        try {
            return filmDAO.selectFilmsByTwoDate(firstYear, secondYear);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération du film", e);
        }
    }

    /*
    * Selection de films communs à 2 acteurs/actrices donnés
     */
    public List<Film> selectFilmsBetweenTwoActors(String firstActeur, String secondActeur) throws BLLException {
        try {
            return filmDAO.selectFilmsBetweenTwoActors(firstActeur, secondActeur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération du film", e);
        }
    }
    /*
    * Selection de films sortis entre 2 années données et qui ont un acteur/actrice donné au casting
     */
    public List<Film> selectFilmsByTwoDateWithActor(String firstYear, String secondYear, String acteur) throws BLLException {
        try {
            return filmDAO.selectFilmsByTwoDateWithActor(firstYear, secondYear, acteur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème  lors de la récupération des films entre deux dates et un acteur");
        }
    }
}
