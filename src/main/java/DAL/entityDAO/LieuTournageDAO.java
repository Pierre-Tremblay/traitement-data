package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.LieuTournage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class LieuTournageDAO implements DAO<LieuTournage> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(LieuTournage objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un lieuTournage");
        }
    }

    @Override
    public void update(LieuTournage objet) throws DALException {
// non utilisé
    }

    @Override
    public void delete(LieuTournage objet) throws DALException {
// non utilisé
    }

    @Override
    public List<LieuTournage> selectAll() throws DALException {
        ResultSet rs;
        List<LieuTournage> lieuTournageList = new ArrayList<>();
        try {
            TypedQuery<LieuTournage> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM LieuTournage a", LieuTournage.class);
            lieuTournageList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'lieuTournages");
        }
        return lieuTournageList;
    }

    @Override
    public LieuTournage selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM LieuTournage a WHERE a.id = :id", LieuTournage.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
