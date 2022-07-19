package BLL;
/*
 * Gestion des erreurs en lien avec la BLL
 */
public class BLLException extends Exception {
    /*
     * Constructeur vide de la class BLLException
     */
    public BLLException() {
        super();
    }

    /*
     * Constructeur de la class BLLException avec le paramètre message
     */
    public BLLException(String message) {
        super(message);
    }

    /*
     * Constructeur de la class BLLException avec les paramètres message et cause
     */
    public BLLException(String message, Throwable cause) {
        super(message, cause);
    }
}
