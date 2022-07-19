package DAL;

import DAL.entityDAO.*;
/**
 * Classe FilmDAO qui permet la création de DAO pour les différents éléments
 */
public class DAOFactory {
    /*
    * Creation DAO pour acteur
     */
    public static ActeurDAO getActeurDAO() {
        return new ActeurDAO();
    }

    /*
     * Creation DAO pour film
     */
    public static FilmDAO getFilmDAO() {
        return new FilmDAO();
    }

    /*
     * Creation DAO pour lieuTournage
     */
    public static LieuTournageDAO getLieuTournageDAO() {
        return new LieuTournageDAO();
    }

    /*
     * Creation DAO pour pays
     */
    public static PaysDAO getPaysDAO() {
        return new PaysDAO();
    }

    /*
     * Creation DAO pour réalisateur
     */
    public static RealisateurDAO getRealisateurDAO() {
        return new RealisateurDAO();
    }

    /*
     * Creation DAO pour role
     */
    public static RoleDAO getRoleDAO() {
        return new RoleDAO();
    }
}
