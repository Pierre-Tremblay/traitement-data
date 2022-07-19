package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.RealisateurDAO;
import Entity.Realisateur;

import java.util.List;

/**
 * Classe RealisateurManager qui permet la gestion des requêtes concernant les réalisateurs
 */
public class RealisateurManager {
    public static volatile RealisateurManager instance;
    private static RealisateurDAO realisateurDAO;

    /*
     * Constructeur de la classe RealisateurManager
     */
    private RealisateurManager() {
        realisateurDAO = DAOFactory.getRealisateurDAO();
    }

    /*
     * Retour de l'instance de la classe RealisateurManager
     */
    public static RealisateurManager getInstance() {
        if (instance == null) {
            synchronized (RealisateurManager.class) {
                if (instance == null) {
                    instance = new RealisateurManager();
                }
            }
        }
        return instance;
    }

    /*
     * Création du realisateur
     */
    public void create(Realisateur realisateur) throws BLLException {
        try {
            Realisateur realisateurDB = realisateurDAO.selectByIdentite(realisateur.getIdentite());
            if (realisateurDB == null) {
                realisateurDAO.create(realisateur);
            } else {
                realisateur.setId(realisateurDB.getId());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'realisateur", e);
        }
    }

    /*
     * Selection de l'ensemble des réalisateurs
     */
    public List<Realisateur> selectAll() throws BLLException {
        try {
            return realisateurDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des realisateurs", e);
        }
    }

    /*
     * Selection d'un réalisateur par son ID
     */
    public Realisateur selectById(long id) throws BLLException {
        try {
            return realisateurDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'realisateur", e);
        }
    }

    /*
     * Mise à jour d'un réalisateur
     */
    public void update(Realisateur realisateur) throws BLLException {
        try {
            realisateurDAO.update(realisateur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'realisateur", e);
        }
    }

    /*
     * Suppression d'un réalisateur
     */
    public void delete(Realisateur realisateur) throws BLLException {
        try {
            realisateurDAO.delete(realisateur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'realisateur", e);
        }
    }
}
