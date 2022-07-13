package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.RealisateurDAO;
import Entity.Realisateur;

import java.util.List;

public class RealisateurManager {
    public static volatile RealisateurManager instance;
    private static RealisateurDAO realisateurDAO;


    private RealisateurManager() {
        realisateurDAO = DAOFactory.getRealisateurDAO();
    }

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

    // Create
    public Realisateur create(Realisateur realisateur) throws BLLException {
        try {
            if (realisateurDAO.selectByIdentite(realisateur.getIdentite()) == null && realisateur.getIdentite() != null) {
                realisateurDAO.create(realisateur);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'realisateur", e);
        }
        return realisateur;
    }
    // Read
    public List<Realisateur> selectAll() throws BLLException {
        try {
            return realisateurDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des realisateurs", e);
        }
    }

    public Realisateur selectById(long id) throws BLLException {
        try {
            return realisateurDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'realisateur", e);
        }
    }
    //    Update
    public void update(Realisateur realisateur) throws BLLException {
        try {
            realisateurDAO.update(realisateur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'realisateur", e);
        }
    }

    //    Delete
    public void delete(Realisateur realisateur) throws BLLException {
        try {
            realisateurDAO.delete(realisateur);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'realisateur", e);
        }
    }
}
