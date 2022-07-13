package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "lieu_tournage")
public class LieuTournage {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("ville")
    @Column(name = "ville")
    private String ville;
    @JsonProperty("etatDept")
    @Column(name = "etatDept")
    private String etatDept;
    @OneToMany(mappedBy = "lieuTournage",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Film> films = new HashSet<Film>();

    public LieuTournage() {
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtatDept() {
        return etatDept;
    }

    public void setEtatDept(String etatDept) {
        this.etatDept = etatDept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieuTournage{");
        sb.append("ville='").append(ville).append('\'');
        sb.append(", etatDept='").append(etatDept).append('\'');

        sb.append('}');
        return sb.toString();
    }
}
