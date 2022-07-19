package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe Réalisateur qui définit ce qu'est un réalisateur
 */
@Entity
@Table(name = "realisateurs")
public class Realisateur {
    /*
     * Identifiant auto-incrementé du réalisateur
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * Nom du réalisateur
     */
    @JsonProperty("identite")
    @Column(name = "identite")
    private String identite;

    /*
     * URL Imdb du réalisateur
     */
    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    /*
     * Liste des films du réalisateur
     */
    @ManyToMany(mappedBy = "realisateurs")
    private Set<Film> films;

    /*
     * Constructeur vide du realisateur
     */
    public Realisateur() {
    }

    /*
     * Getter de l'identifiant auto-incrementé du réalisateur
     */
    public int getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé du réalisateur
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getter du nom du réalisateur
     */
    public String getIdentite() {
        return identite;
    }

    /*
     * Setter du nom du réalisateur
     */
    public void setIdentite(String identite) {
        this.identite = identite;
    }

    /*
     * Getter de l'URL Imdb du réalisateur
     */
    public String getUrl() {
        return url;
    }

    /*
     * Setter de l'URL Imdb du réalisateur
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * Getter de la liste de films du réalisateur
     */
    public Set<Film> getFilms() {
        return films;
    }

    /*
     * Setter de la liste de films du réalisateur
     */
    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    /*
     * ToString de la classe Realisateur
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Realisateur{");
        sb.append("id=").append(id);
        sb.append(", identite='").append(identite).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", films=").append(films);
        sb.append('}');
        return sb.toString();
    }

    /*
     * Hachage du nom du réalisateur
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identite == null) ? 0 : identite.hashCode());
		return result;
	}

    /*
     * Vérification de l'unicité du nom du réalisateur
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realisateur other = (Realisateur) obj;
		if (identite == null) {
			if (other.identite != null)
				return false;
		} else if (!identite.equals(other.identite))
			return false;
		return true;
	}
}
