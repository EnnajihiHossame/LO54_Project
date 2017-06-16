package core.Entity;

import java.io.Serializable;

/**
 * Created by ennajihihoussame on 16/06/2017.
 */
public class LocationEntity implements Serializable, IEntity {
    private int idLocation;
    private String city;

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location{");
        builder.append("id=").append(idLocation);
        builder.append(", city=").append(city);
        builder.append("}");
        return builder.toString();
    }
}
