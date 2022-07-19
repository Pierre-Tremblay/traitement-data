package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.ActeurDAO;
import Entity.Acteur;

import java.util.List;
/**
 * Classe ActeurManager qui permet la gestion des requêtes concernant les acteurs
 */
public class ActeurManager {
    public static volatile ActeurManager instance;
    private static ActeurDAO acteurDAO;

    /*
     * Constructeur de la classe ActeurManager
     */
    private ActeurManager() {
        acteurDAO = DAOFactory.getActeurDAO();
    }

    /*
     * Retour de l'instance de la classe ActeurManager
     */
    public static ActeurManager getInstance() {
        if (instance == null) {
            synchronized (ActeurManager.class) {
                if (instance == null) {
                    instance = new ActeurManager();
                }
            }
        }
        return instance;
    }

    /*
     * Création de l'acteur
     */
    public void create(Acteur acteur) throws BLLException, DALException {
        try {
            Acteur acteurDB = acteurDAO.selectByIdentifiant(acteur.getIdentifiant());
            if (acteurDB == null) {
                acteurDAO.create(acteur);
            } else {
                acteur.setId(acteurDB.getId());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'acteur", e);
        }


    }

    /*
     * Selection de l'ensemble des acteurs
     */
    public List<Acteur> selectAll() throws BLLException {
        try {
            return acteurDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des acteurs", e);
        }
    }
    /*
     * Selection d'un acteur par son ID
     */
    public Acteur selectById(long id) throws BLLException {
        try {
            return acteurDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'acteur", e);
        }
    }

    /*
     * Mise à jour de l'acteur
     */
    public void update(Acteur acteur) throws BLLException {
        try {
            acteurDAO.update(acteur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'acteur", e);
        }
    }

    /*
     * Suppression de l'acteur
     */
    public void delete(Acteur acteur) throws BLLException {
        try {
            acteurDAO.delete(acteur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'acteur", e);
        }
    }

    /*
     * Selection d'un acteur par ses films
     */
    public List<Acteur> selectActorsByFilm(String nom) throws BLLException {
        try {
            return acteurDAO.selectActorsByFilm(nom);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération de l'acteur", e);
        }
    }

    /*
     * Selection d'acteurs qui ont en commun deux films
     */
    public List<Acteur> selectActorsBetweenTwoFilms(String firstFilm, String secondFilm) throws BLLException {
        try {
            return acteurDAO.selectActorsBetweenTwoFilms(firstFilm, secondFilm);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération de l'acteur", e);
        }
    }

}
