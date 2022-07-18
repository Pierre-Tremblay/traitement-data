package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("characterName")
    @Column(name = "characterName")
    private String characterName;

    @ManyToMany
    @JoinTable(name = "films_roles", joinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_film", referencedColumnName = "id"))
    private Set<Film> films;

    @ManyToOne
    @JoinColumn(name = "id_acteur")
    private Acteur acteur;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @JsonProperty("film")
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Acteur getActeurs() {
        return acteur;
    }

    public void setActeurs(Acteur acteurs) {
        this.acteur = acteurs;
    }

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
