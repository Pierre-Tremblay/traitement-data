package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Film")
public class Film {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("pays")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pays")
    private Pays pays;
    @JsonProperty("nom")
    @Column(name = "nom")
    private String nom;
    @JsonProperty("url")
    @Column(name = "url")
    private String url;
    @JsonProperty("plot")
    @Column(name = "plot")
    private String plot;
    @JsonProperty("id")
    @Column(name = "identifiant")
    private String identifiant;
    @JsonProperty("langue")
    @Column(name = "langue")
    private String langue;
    @JsonProperty("lieuTournage")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lieuTournage")
    private LieuTournage lieuTournage;
    @JsonProperty("realisateurs")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "films_realisateurs", joinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_realisateur", referencedColumnName = "id"))
    private Set<Realisateur> realisateurs;
    @JsonProperty("anneeSortie")
    @Column(name = "anneeSortie")
    private String anneeSortie;
//    @JsonProperty("genres")
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "films_genres", joinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_genre", referencedColumnName = "id"))
//    private Set<Genre> genres;

    @JsonProperty("roles")
    @ManyToMany(mappedBy = "films")
    private Set<Role> roles;
    @JsonProperty("acteurs")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "film_acteur", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id"))
    private Set<Acteur> acteurs;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "film_genre",joinColumns=@JoinColumn(name = "film_id"))
    private List<String> genres;

    public Film() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public LieuTournage getLieuTournage() {
        return lieuTournage;
    }

    public void setLieuTournage(LieuTournage lieuTournage) {
        this.lieuTournage = lieuTournage;
    }


    public String getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(String anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public Set<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(Set<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

//    public Set<Genre> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(Set<Genre> genres) {
//        this.genres = genres;
//    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("id=").append(id);
        sb.append(", pays=").append(pays);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", plot='").append(plot).append('\'');
        sb.append(", identifiant='").append(identifiant).append('\'');
        sb.append(", langue='").append(langue).append('\'');
        sb.append(", lieuTournage=").append(lieuTournage);
        sb.append(", realisateurs=").append(realisateurs);
        sb.append(", anneeSortie='").append(anneeSortie).append('\'');
//        sb.append(", genres=").append(genres);
        sb.append(", Roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
