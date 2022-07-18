package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;

@Embeddable
public class Naissance {
    @JsonProperty("dateNaissance")
    private String dateNaissance;
    @JsonProperty("lieuNaissance")
    private String lieuNaissance;

    public Naissance() {
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Naissance{");
        sb.append("dateNaissance='").append(dateNaissance).append('\'');
        sb.append(", lieuNaissance='").append(lieuNaissance).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
