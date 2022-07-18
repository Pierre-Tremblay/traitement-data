package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "realisateurs")
public class Realisateur {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @JsonProperty("identite")
    @Column(name = "identite")
    private String identite;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;
    
    @ManyToMany(mappedBy = "realisateurs")
    private Set<Film> films;

    public Realisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Realisateur other = (Realisateur) obj;
		if (identite == null) {
			if (other.identite != null)
				return false;
		} else if (!identite.equals(other.identite))
			return false;
		return true;
	}
}
