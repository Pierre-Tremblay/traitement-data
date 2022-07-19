package BLL.entityManager;

import BLL.BLLException;
import DAL.DALException;
import DAL.DAOFactory;
import DAL.entityDAO.RoleDAO;
import Entity.Role;

import java.util.List;

/**
 * Classe RoleManager qui permet la gestion des requêtes concernant les roles
 */
public class RoleManager {
    public static volatile RoleManager instance;
    private static RoleDAO roleDAO;

    /*
     * Constructeur de la classe RoleManager
     */
    private RoleManager() {
        roleDAO = DAOFactory.getRoleDAO();
    }
    /*
     * Retour de l'instance de la classe RoleManager
     */
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

    /*
     * Création du role
     */
    public Role create(Role role) throws BLLException {
        try {
        	Role roleDB = roleDAO.selectById(role.getId());
            if (roleDB == null) {
                roleDAO.create(role);
            } else {
                role.setId(roleDB.getId());
            }
        } catch (DALException e) {
            throw new BLLException("Erreur lors de l'insertion de l'role", e);
        }
        return role;
    }
    /*
     * Selection de l'ensemble des roles
     */
    public List<Role> selectAll() throws BLLException {
        try {
            return roleDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la récupération des roles", e);
        }
    }

    /*
     * Selection d'un role par son ID
     */
    public Role selectById(long id) throws BLLException {
        try {
            return roleDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la selection de l'role", e);
        }
    }
    /*
     * Mise à jour d'un role
     */
    public void update(Role role) throws BLLException {
        try {
            roleDAO.update(role);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la màj de l'role", e);
        }
    }

    /*
     * Suppression d'un role
     */
    public void delete(Role role) throws BLLException {
        try {
            roleDAO.delete(role);
        } catch (DALException e) {
            throw new BLLException("ERREUR SURVENUE : Problème lors de la suppression de l'role", e);
        }
    }
}
