package DAL;

import BLL.PersistenceManager;
import Entity.Acteur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActeurDAO implements DAO<Acteur> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    @Override
    public void create(Acteur objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un acteur");
        }
    }

    @Override
    public void update(Acteur objet) throws DALException {
// non utilisé
    }

    @Override
    public void delete(Acteur objet) throws DALException {
// non utilisé
    }

    @Override
    public List<Acteur> selectAll() throws DALException {
        ResultSet rs;
        List<Acteur> acteurList = new ArrayList<>();
        try {
            TypedQuery<Acteur> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Acteur a", Acteur.class);
            acteurList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'acteurs");
        }
        return acteurList;
    }

    @Override
    public Acteur selectById(int id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Acteur a WHERE a.id = :id", Acteur.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
