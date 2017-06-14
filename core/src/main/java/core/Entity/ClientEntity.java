package core.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ennajihihoussame on 28/05/2017.
 */
@Entity
@Table(name = "CLIENT", schema = "LO54_database", catalog = "")
public class ClientEntity implements Serializable, IEntity {
    private int idClient;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;
    private int idCourseSession;

    public ClientEntity() {
    }

    public ClientEntity(String lastname, String firstname, String address, String phone, String email, int idCourseSession) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idCourseSession = idCourseSession;
    }

    @Id
    @Column(name = "ID_CLIENT", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "LASTNAME", nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "FIRSTNAME", nullable = false, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "PHONE", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (idClient != that.idClient) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ID_COURSE_SESSION", nullable = false)
    public int getIdCourseSession() {
        return idCourseSession;
    }

    public void setIdCourseSession(int idCourseSession) {
        this.idCourseSession = idCourseSession;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Client{");
        builder.append("id=").append(idClient);
        builder.append(", lastName=").append(lastname);
        builder.append(", firstName=").append(firstname);
        builder.append(", address=").append(address);
        builder.append(", phone=").append(phone);
        builder.append(", email=").append(email);
        builder.append(", courseSession=").append(idCourseSession);
        builder.append("}");
        return builder.toString();
    }
}
