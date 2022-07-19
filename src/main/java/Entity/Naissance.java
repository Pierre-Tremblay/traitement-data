package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;

/**
 * Classe Naissance qui définit ce qu'est une date de naissance et un lieu de naissance
 */
@Embeddable
public class Naissance {

    /*
     * Date de naissance de Naissance
     */
    @JsonProperty("dateNaissance")
    private String dateNaissance;

    /*
     * Lieu de naissance de Naissance
     */
    @JsonProperty("lieuNaissance")
    private String lieuNaissance;

    /*
     * Constructeur vide de Naissance
     */
    public Naissance() {
    }

    /*
     * Getter de la date de naissance de Naissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /*
     * Setter de la date de naissance de Naissance
     */
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /*
     * Getter du lieu de naissance de Naissance
     */
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    /*
     * Setter du lieu de naissance de Naissance
     */
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /*
     * ToString de la classe Naissance
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Naissance{");
        sb.append("dateNaissance='").append(dateNaissance).append('\'');
        sb.append(", lieuNaissance='").append(lieuNaissance).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
