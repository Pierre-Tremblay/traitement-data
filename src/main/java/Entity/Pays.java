package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe Pays qui définit ce qu'est un pays
 */
@Entity
@Table(name = "pays")
public class Pays {

    /*
     * Identifiant auto-incrementé du pays
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * Nom du pays
     */
    @JsonProperty("nom")
    @Column(name = "nom", unique = true)
    private String nom;

    /*
     * URL Imdb du pays
     */
    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    /*
     * Liste des films du pays
     */
    @JsonProperty("film")
    @OneToMany(mappedBy = "pays")
    private Set<Film> films;

    /*
     * Constructeur vide du pays
     */
    public Pays() {
    }

    /*
     * Getter de l'identifiant auto-incrementé du pays
     */
    public int getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé du pays
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getter du nom du pays
     */
    public String getNom() {
        return nom;
    }

    /*
     * Setter du nom du pays
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /*
     * Getter de l'URL Imdb du pays
     */
    public String getUrl() {
        return url;
    }

    /*
     * Setter de l'URL Imdb du pays
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * ToString de la classe Pays
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
