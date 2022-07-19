package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe Role qui définit ce qu'est un roles
 */
@Entity
@Table(name = "roles")
public class Role {

    /*
     * Identifiant auto-incrementé du role
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * Nom du role
     */
    @JsonProperty("characterName")
    @Column(name = "characterName")
    private String characterName;

    /*
     * Liste des films de role
     */
    @ManyToMany
    @JoinTable(name = "films_roles", joinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"))
    private Set<Film> films;
    /*
     * Acteur du role
     */
    @ManyToOne
    @JoinColumn(name = "id_acteur")
    private Acteur acteur;

    /*
     * Constructeur vide du role
     */
    public Role() {
    }

    /*
     * Getter de l'identifiant auto-incrementé du role
     */
    public int getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé du role
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getter du nom du role
     */
    public String getCharacterName() {
        return characterName;
    }

    /*
     * Setter du nom du role
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /*
     * Getter de la liste de films du role
     */
    @JsonProperty("film")
    public Set<Film> getFilms() {
        return films;
    }

    /*
     * Setter de la liste de films du role
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    /*
     * Getter de l'acteur du role
     */
    public Acteur getActeurs() {
        return acteur;
    }

    /*
     * Setter de l'acteur du role
     */
    public void setActeurs(Acteur acteurs) {
        this.acteur = acteurs;
    }

    /*
     * ToString de la classe Role
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", characterName='").append(characterName).append('\'');
        sb.append(", films=").append(films);
        sb.append(", acteurs=").append(acteur);
        sb.append('}');
        return sb.toString();
    }
}
