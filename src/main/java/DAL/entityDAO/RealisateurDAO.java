package DAL;

import BLL.PersistenceManager;
import Entity.Realisateur;
import Entity.Realisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RealisateurDAO implements DAO<Realisateur> {
    EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Realisateur objet) throws DALException {
        try {
            ConnexionJPA.getProperty().getTransaction().begin();
            ConnexionJPA.getProperty().persist(objet);
            ConnexionJPA.getProperty().getTransaction().commit();

        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la création d'un realisateur");
        }
    }

    @Override
    public void update(Realisateur objet) throws DALException {

    }

    @Override
    public void delete(Realisateur objet) throws DALException {

    }

    @Override
    public List<Realisateur> selectAll() throws DALException {
        ResultSet rs;
        List<Realisateur> realisateurList = new ArrayList<>();
        try {
            TypedQuery<Realisateur> selectAll = ConnexionJPA.getProperty().createQuery("SELECT a FROM Realisateur a", Realisateur.class);
            realisateurList = selectAll.getResultList();
        } catch (DALException e) {
            throw new DALException("ERREUR SURVENUE : Problème lors de la récupération de la liste d'realisateurs");
        }
        return realisateurList;
    }

    @Override
    public Realisateur selectById(int id) throws DALException {
        try {
            return em.createQuery("SELECT a FROM Realisateur a WHERE a.id = :id", Realisateur.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
