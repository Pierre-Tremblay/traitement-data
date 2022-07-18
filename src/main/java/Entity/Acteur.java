package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acteur")
public class Acteur {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @JsonProperty("identite")
    @Column(name = "identite")
    private String identite;

    @JsonProperty("naissance")
    @Embedded
    private Naissance naissance;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;
    
    @JsonProperty("id")
    @Column(name = "identifiant", unique=true)
    private String identifiant;

    @JsonProperty("roles")
    @ManyToMany
    @JoinTable(name = "acteurs_roles", joinColumns = @JoinColumn(name = "id_acteur", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
    
    @JsonProperty("film")
    @ManyToMany(mappedBy = "acteurs")
    private Set<Film> films =new HashSet<>();


    public Acteur() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public Naissance getNaissance() {
        return naissance;
    }

    public void setNaissance(Naissance naissance) {
        this.naissance = naissance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((identite == null) ? 0 : identite.hashCode());
		return result;
	}

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

