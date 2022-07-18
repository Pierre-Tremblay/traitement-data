package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.PaysDAO;
import Entity.Pays;

import java.util.List;

public class PaysManager {
    public static volatile PaysManager instance;
    private static PaysDAO paysDAO;


    private PaysManager() {
        paysDAO = DAOFactory.getPaysDAO();
    }

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

    // Create
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
    // Read
    public List<Pays> selectAll() throws BLLException {
        try {
            return paysDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des payss", e);
        }
    }

    public Pays selectById(long id) throws BLLException {
        try {
            return paysDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'pays", e);
        }
    }
    //    Update
    public void update(Pays pays) throws BLLException {
        try {
            paysDAO.update(pays);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'pays", e);
        }
    }

    //    Delete
    public void delete(Pays pays) throws BLLException {
        try {
            paysDAO.delete(pays);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'pays", e);
        }
    }
}
