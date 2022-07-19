package DAL;
/*
* Gestion des erreurs en lien avec la BDD
 */
public class DALException extends Exception {
    /*
     * Constructeur vide de la class DALException
     */
    public DALException() {
        super();
    }

    /*
     * Constructeur de la class DALException avec le paramètre message
     */
    public DALException(String message) {
        super("Erreur DAL : " + message);
    }

    /*
     * Constructeur de la class DALException avec le paramètre message et cause
     */
    public DALException(String message, Throwable cause) {
        super("Erreur DAL : " + message, cause);
    }
}