package DAL.entityDAO;

import BLL.entityManager.PersistenceManager;
import DAL.ConnexionJPA;
import DAL.DALException;
import DAL.DAO;
import Entity.Pays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaysDAO implements DAO<Pays> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Pays objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un pays");
        }
    }

    @Override
    public void update(Pays objet) throws DALException {
// non utilisé
    }

    @Override
    public void delete(Pays objet) throws DALException {
// non utilisé
    }

    @Override
    public List<Pays> selectAll() throws DALException {
        ResultSet rs;
        List<Pays> paysList = new ArrayList<>();
        try {
            TypedQuery<Pays> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Pays a", Pays.class);
            paysList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'payss");
        }
        return paysList;
    }

    @Override
    public Pays selectById(long id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Pays a WHERE a.id = :id", Pays.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

	public Pays selectByNom(String nom) {
		 try {
	            return em.createQuery("SELECT a FROM Pays a WHERE a.nom = :nom", Pays.class).setParameter("nom", nom).getSingleResult();
	        } catch (Exception e) {
	            return null;
	        }
	}
}
