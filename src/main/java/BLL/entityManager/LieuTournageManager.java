package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.LieuTournageDAO;
import Entity.LieuTournage;

import java.util.List;

/**
 * Classe LieuTournageManager qui permet la gestion des requêtes concernant les lieux de tournage
 */
public class LieuTournageManager {
    public static volatile LieuTournageManager instance;
    private static LieuTournageDAO lieuTournageDAO;


    /*
     * Constructeur de la classe LieuTournageManager
     */
    private LieuTournageManager() {
        lieuTournageDAO = DAOFactory.getLieuTournageDAO();
    }

    /*
     * Retour de l'instance de la classe LieuTournageManager
     */
    public static LieuTournageManager getInstance() {
        if (instance == null) {
            synchronized (LieuTournageManager.class) {
                if (instance == null) {
                    instance = new LieuTournageManager();
                }
            }
        }
        return instance;
    }

    /*
     * Création du lieu de tournage
     */
    public LieuTournage create(LieuTournage lieuTournage) throws BLLException {
        try {
            if (lieuTournageDAO.selectById(lieuTournage.getId()) == null && lieuTournage.getId() != 0) {
                lieuTournageDAO.create(lieuTournage);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'lieuTournage", e);
        }
        return lieuTournage;
    }

    /*
     * Selection de l'ensemble des lieu de tournage
     */
    public List<LieuTournage> selectAll() throws BLLException {
        try {
            return lieuTournageDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des lieuTournages", e);
        }
    }

    /*
     * Selection d'un lieu de tournage par son ID
     */
    public LieuTournage selectById(long id) throws BLLException {
        try {
            return lieuTournageDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'lieuTournage", e);
        }
    }

    /*
     * Mise à jour d'un lieu de tournage
     */
    public void update(LieuTournage lieuTournage) throws BLLException {
        try {
            lieuTournageDAO.update(lieuTournage);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'lieuTournage", e);
        }
    }

    /*
     * Suppression d'un lieu de tournage
     */
    public void delete(LieuTournage lieuTournage) throws BLLException {
        try {
            lieuTournageDAO.delete(lieuTournage);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'lieuTournage", e);
        }
    }
}
