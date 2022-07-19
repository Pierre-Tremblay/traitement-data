package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Acteur qui définit ce qu'est un acteur
 */
@Entity
@Table(name = "acteur")
public class Acteur {

    /*
     * Identifiant auto-incrementé de l'acteur
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
     * Nom de l'acteur
     */
    @JsonProperty("identite")
    @Column(name = "identite")
    private String identite;

    /*
     * Date de naissance et lieu de naissance de l'acteur
     */
    @JsonProperty("naissance")
    @Embedded
    private Naissance naissance;

    /*
     * URL Imdb de l'acteur
     */
    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    /*
     * Identifiant Imdb de l'acteur
     */
    @JsonProperty("id")
    @Column(name = "identifiant", unique = true)
    private String identifiant;

    /*
     * Liste des rôles de l'acteur
     */
    @JsonProperty("roles")
    @OneToMany(mappedBy = "acteur")
    private Set<Role> roles = new HashSet<>();
    /*
     * Liste des films de l'acteur
     */
    @JsonProperty("film")
    @ManyToMany(mappedBy = "acteurs")
    private Set<Film> films = new HashSet<>();

    /*
     * Constructeur vide de l'acteur
     */
    public Acteur() {
    }

    /*
     * Getter de l'identifiant auto-incrementé de l'acteur
     */
    public long getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé de l'acteur
     */
    public void setId(long id) {
        this.id = id;
    }

    /*
     * Getter du nom de l'acteur
     */
    public String getIdentite() {
        return identite;
    }

    /*
     * Setter du nom de l'acteur
     */
    public void setIdentite(String identite) {
        this.identite = identite;
    }

    /*
     * Getter de la date de naissance et du lieu de naissance de l'acteur
     */
    public Naissance getNaissance() {
        return naissance;
    }

    /*
     * Setter de la date de naissance et du lieu de naissance de l'acteur
     */
    public void setNaissance(Naissance naissance) {
        this.naissance = naissance;
    }

    /*
     * Getter de l'URL Imdb de l'acteur
     */
    public String getUrl() {
        return url;
    }

    /*
     * Setter de l'URL Imdb de l'acteur
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * Getter de l'identifiant Imdb de l'acteur
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /*
     * Setter de l'identifiant Imdb de l'acteur
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /*
     * Getter de la liste de rôles de l'acteur
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /*
     * Setter de la liste de rôles de l'acteur
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /*
     * Getter de la liste de films de l'acteur
     */
    public Set<Film> getFilms() {
        return films;
    }
    /*
     * Setter de la liste de films de l'acteur
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    /*
     * ToString de la classe Acteur
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Acteur{");
        sb.append("id=").append(id);
        sb.append(", identite='").append(identite).append('\'');
        sb.append(", naissance=").append(naissance);
        sb.append(", url='").append(url).append('\'');
        sb.append(", identifiant='").append(identifiant).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }

    /*
     * Hachage de l'identifiant et du nom de l'acteur
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
        result = prime * result + ((identite == null) ? 0 : identite.hashCode());
        return result;
    }

    /*
     * Vérification de l'unicité de l'identifiant et du nom de l'acteur
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Acteur other = (Acteur) obj;
        if (identifiant == null) {
            if (other.identifiant != null)
                return false;
        } else if (!identifiant.equals(other.identifiant))
            return false;
        if (identite == null) {
            if (other.identite != null)
                return false;
        } else if (!identite.equals(other.identite))
            return false;
        return true;
    }
}

