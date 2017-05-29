package core.Entity;

import javax.persistence.*;

/**
 * Created by ennajihihoussame on 28/05/2017.
 */
@Entity
@Table(name = "LOCATION", schema = "LO54_database", catalog = "")
public class LocationEntity {
    private int idLocation;
    private String city;

    @Id
    @Column(name = "ID_LOCATION", nullable = false)
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    @Basic
    @Column(name = "CITY", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (idLocation != that.idLocation) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLocation;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
