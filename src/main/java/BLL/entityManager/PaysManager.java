package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.PaysDAO;
import Entity.Pays;

import java.util.List;
/**
 * Classe PaysManager qui permet la gestion des requêtes concernant les pays
 */
public class PaysManager {
    public static volatile PaysManager instance;
    private static PaysDAO paysDAO;

    /*
     * Constructeur de la classe PaysManager
     */
    private PaysManager() {
        paysDAO = DAOFactory.getPaysDAO();
    }
    /*
     * Retour de l'instance de la classe PaysManager
     */
    public static PaysManager getInstance() {
        if (instance == null) {
            synchronized (PaysManager.class) {
                if (instance == null) {
                    instance = new PaysManager();
                }
            }
        }
        return instance;
    }

    /*
     * Création du pays
     */
    public Pays create(Pays pays) throws BLLException {
        try {
        	Pays paysDB = paysDAO.selectByNom(pays.getNom());
            if (paysDB == null) {
                paysDAO.create(pays);
            } else {
            	pays.setId(paysDB.getId());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'pays", e);
        }
        return pays;
    }
    /*
     * Selection de l'ensemble des pays
     */
    public List<Pays> selectAll() throws BLLException {
        try {
            return paysDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des payss", e);
        }
    }
    /*
     * Selection d'un pays par son ID
     */
    public Pays selectById(long id) throws BLLException {
        try {
            return paysDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'pays", e);
        }
    }
    /*
     * Mise à jour d'un pays
     */
    public void update(Pays pays) throws BLLException {
        try {
            paysDAO.update(pays);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'pays", e);
        }
    }

    /*
     * Suppression d'un pays
     */
    public void delete(Pays pays) throws BLLException {
        try {
            paysDAO.delete(pays);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'pays", e);
        }
    }
}
