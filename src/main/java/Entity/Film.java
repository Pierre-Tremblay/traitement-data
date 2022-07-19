package Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe Film qui définit ce qu'est un film
 */
@Entity
@Table(name = "Film")
public class Film {
    /*
     * Identifiant auto-incrementé du film
     */
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
     * Pays du film
     */
    @JsonProperty("pays")
    @ManyToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    /*
     * Nom du film
     */
    @JsonProperty("nom")
    @Column(name = "nom")
    private String nom;

    /*
     * URL du film
     */
    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    /*
     * Plot du film
     */
    @JsonProperty("plot")
    @Column(name = "plot")
    private String plot;

    /*
     * Identifiant du film
     */
    @JsonProperty("id")
    @Column(name = "identifiant", unique=true)
    private String identifiant;

    /*
     * Langue du film
     */
    @JsonProperty("langue")
    @Column(name = "langue")
    private String langue;

    /*
     * Lieu de tournage du film
     */
    @JsonProperty("lieuTournage")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lieuTournage")
    private LieuTournage lieuTournage;

    /*
     * Liste de réalisateurs du film
     */
    @JsonProperty("realisateurs")
    @ManyToMany
    @JoinTable(name = "films_realisateurs", joinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_realisateur", referencedColumnName = "id"))
    private Set<Realisateur> realisateurs;

    /*
     * Année de sortie du film
     */
    @JsonProperty("anneeSortie")
    @Column(name = "anneeSortie")
    private String anneeSortie;

    /*
     * Liste de rôles du film
     */
    @JsonProperty("roles")
    @ManyToMany(mappedBy = "films")
    private Set<Role> roles;

    /*
     * Liste d'acteurs du film
     */
    @JsonProperty("acteurs")
    @ManyToMany
    @JoinTable(name = "films_acteurs", joinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_acteur", referencedColumnName = "id"))
    private Set<Acteur> acteurs;

    /*
     * Liste de genres du film
     */
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "film_genre",joinColumns=@JoinColumn(name = "film_id"))
    private List<String> genres;

    /*
     * Constructeur vide du film
     */
    public Film() {
    }

    /*
     * Getter de l'identifiant auto-incrementé du film
     */
    public int getId() {
        return id;
    }

    /*
     * Setter de l'identifiant auto-incrementé du film
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getter du pays du film
     */
    public Pays getPays() {
        return pays;
    }

    /*
     * Setter du pays du film
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /*
     * Getter du nom du film
     */
    public String getNom() {
        return nom;
    }

    /*
     * Setter du nom du film
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /*
     * Getter de l'URL Imdb du film
     */
    public String getUrl() {
        return url;
    }

    /*
     * Setter de l'URL Imdb du film
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /*
     * Getter du plot du film
     */
    public String getPlot() {
        return plot;
    }

    /*
     * Setter du plot du film
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /*
     * Getter de l'identifiant Imdb du film
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /*
     * Setter de l'identifiant Imdb du film
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /*
     * Getter de la langue du film
     */
    public String getLangue() {
        return langue;
    }

    /*
     * Setter de la langue du film
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /*
     * Getter du lieu de tournage du film
     */
    public LieuTournage getLieuTournage() {
        return lieuTournage;
    }

    /*
     * Setter du lieu de tournage du film
     */
    public void setLieuTournage(LieuTournage lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    /*
     * Getter de l'année de sortie du film
     */
    public String getAnneeSortie() {
        return anneeSortie;
    }

    /*
     * Setter de l'année de sortie du film
     */
    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    /*
     * Getter de la liste des réalisateurs du film
     */
    public Set<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    /*
     * Setter de la liste des réalisateurs du film
     */
    public void setRealisateurs(Set<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    /*
     * Getter de la liste des genres du film
     */
    public List<String> getGenres() {
        return genres;
    }

    /*
     * Setter de la liste des genres du film
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /*
     * Getter de la liste des acteurs du film
     */
    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    /*
     * Setter de la liste des acteurs du film
     */
    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    /*
     * Getter de la liste des roles du film
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /*
     * Setter de la liste des roles du film
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /*
     * ToString de la classe Film
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("id=").append(id);
        sb.append(", pays=").append(pays);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", identifiant='").append(identifiant).append('\'');
        sb.append(", langue='").append(langue).append('\'');
        sb.append(", lieuTournage=").append(lieuTournage);
        sb.append(", anneeSortie='").append(anneeSortie).append('\'');
        sb.append(", genres=").append(genres);
        sb.append('}');
        return sb.toString();
    }

    /*
     * Hachage de l'identifiant et du nom du film
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

    /*
     * Vérification de l'unicité de l'identifiant et du nom du film
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}
