package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.RoleDAO;
import Entity.Role;

import java.util.List;

public class RoleManager {
    public static volatile RoleManager instance;
    private static RoleDAO roleDAO;


    private RoleManager() {
        roleDAO = DAOFactory.getRoleDAO();
    }

    public static RoleManager getInstance() {
        if (instance == null) {
            synchronized (RoleManager.class) {
                if (instance == null) {
                    instance = new RoleManager();
                }
            }
        }
        return instance;
    }

    // Create
    public Role create(Role role) throws BLLException {
        try {
            if (roleDAO.selectById(role.getId()) == null && role.getId() != 0) {
                roleDAO.create(role);
            } else {
                return null;
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'role", e);
        }
        return role;
    }
    // Read
    public List<Role> selectAll() throws BLLException {
        try {
            return roleDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des roles", e);
        }
    }

    public Role selectById(long id) throws BLLException {
        try {
            return roleDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'role", e);
        }
    }
    //    Update
    public void update(Role role) throws BLLException {
        try {
            roleDAO.update(role);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'role", e);
        }
    }

    //    Delete
    public void delete(Role role) throws BLLException {
        try {
            roleDAO.delete(role);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'role", e);
        }
    }
}
