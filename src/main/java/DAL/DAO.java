package DAL;

import java.util.List;

/**
 * Classe DAO qui permet la gestion des éléments en BDD
 */
public interface DAO<T> {
    /*
     * Methode qui permet la création d'un objet en BDD
     */
    public void create(T objet) throws DALException;

    /*
     * Methode qui permet la màj d'un objet en BDD
     */
    public void update(T objet) throws DALException;

    /*
     * Methode qui permet la suppression d'un objet en BDD
     */
    public void delete(T objet) throws DALException;

    /*
     * Methode qui permet la selection de tous les objets en BDD
     */
    public List<T> selectAll() throws DALException;

    /*
     * Methode qui permet la selection d'objets par leur id en BDD
     */
    public T selectById(long id) throws DALException;
}