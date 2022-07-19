package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe LieuTournage qui définit ce qu'est un lieu de tournage
 */
@Entity
@Table(name = "lieu_tournage")
public class LieuTournage {
    /*
     * Identifiant auto-incrementé du lieu de tournage
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * Ville du lieu de tournage
     */
    @JsonProperty("ville")
    @Column(name = "ville")
    private String ville;

    /*
     * Etat et/ou département du lieu de tournage
     */
    @JsonProperty("etatDept")
    @Column(name = "etatDept")
    private String etatDept;

    /*
     * Liste des films du lieu de tournage
     */
    @JsonProperty("films")
    @OneToMany(mappedBy = "lieuTournage")
    private Set<Film> films = new HashSet<Film>();

    /*
     * Constructeur vide du lieu de tournage
     */
    public LieuTournage() {
    }

    /*
     * Getter de l'identifiant auto-incrementé du lieu de tournage
     */
    public int getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé du lieu de tournage
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getter de la ville du lieu de tournage
     */
    public String getVille() {
        return ville;
    }

    /*
     * Setter de la ville du lieu de tournage
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /*
     * Getter de l'état et/ou département du lieu de tournage
     */
    public String getEtatDept() {
        return etatDept;
    }

    /*
     * Setter de l'état et/ou département du lieu de tournage
     */
    public void setEtatDept(String etatDept) {
        this.etatDept = etatDept;
    }

    /*
     * Getter de la liste des films du lieu de tournage
     */
    public Set<Film> getFilms() {
        return films;
    }

    /*
     * Setter de la liste des films du lieu de tournage
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    /*
     * ToString de la classe LieuTournage
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieuTournage{");
        sb.append("ville='").append(ville).append('\'');
        sb.append(", etatDept='").append(etatDept).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
