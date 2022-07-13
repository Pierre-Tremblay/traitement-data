package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.LieuTournageDAO;
import Entity.LieuTournage;

import java.util.List;

public class LieuTournageManager {
    public static volatile LieuTournageManager instance;
    private static LieuTournageDAO lieuTournageDAO;


    private LieuTournageManager() {
        lieuTournageDAO = DAOFactory.getLieuTournageDAO();
    }

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

    // Create
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
    // Read
    public List<LieuTournage> selectAll() throws BLLException {
        try {
            return lieuTournageDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des lieuTournages", e);
        }
    }

    public LieuTournage selectById(long id) throws BLLException {
        try {
            return lieuTournageDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'lieuTournage", e);
        }
    }
    //    Update
    public void update(LieuTournage lieuTournage) throws BLLException {
        try {
            lieuTournageDAO.update(lieuTournage);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'lieuTournage", e);
        }
    }

    //    Delete
    public void delete(LieuTournage lieuTournage) throws BLLException {
        try {
            lieuTournageDAO.delete(lieuTournage);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'lieuTournage", e);
        }
    }
}
