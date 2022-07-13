package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

//@Entity
//@Table(name = "genre")
public class Genre {
//
//    @Id
//    @JsonIgnore
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @JsonProperty("name")
//    @Column(name = "name")
//    private String name;
//    @ManyToMany(mappedBy = "genres",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Film> films;
//
//    public Genre() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Film> getFilms() {
//        return films;
//    }
//
//    public void setFilms(Set<Film> films) {
//        this.films = films;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Genre{");
//        sb.append("id=").append(id);
//        sb.append(", name='").append(name).append('\'');
//        sb.append(", films=").append(films);
//        sb.append('}');
//        return sb.toString();
//    }
}
