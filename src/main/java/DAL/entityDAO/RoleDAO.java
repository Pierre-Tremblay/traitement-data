package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe RoleDAO qui permet la gestion des roles en BDD
 */
public class RoleDAO implements DAO<Role> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    /*
     * Création role en BDD
     */
    @Override
    public void create(Role objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un role");
        }
    }

    /*
     * Mise à jour du role en BDD
     */
    @Override
    public void update(Role objet) throws DALException {
// non utilisé
    }

    /*
     * Suppression du role en BDD
     */
    @Override
    public void delete(Role objet) throws DALException {
// non utilisé
    }

    /*
     * Selection de l'ensemble des roles en BDD
     */
    @Override
    public List<Role> selectAll() throws DALException {
        ResultSet rs;
        List<Role> roleList = new ArrayList<>();
        try {
            TypedQuery<Role> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Role a", Role.class);
            roleList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'roles");
        }
        return roleList;
    }

    /*
     * Selection d'un role par son ID en BDD
     */
    @Override
    public Role selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Role a WHERE a.id = :id", Role.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
