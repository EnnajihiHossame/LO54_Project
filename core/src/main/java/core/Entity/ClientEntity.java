package core.Entity;

import java.io.Serializable;

/**
 * Created by ennajihihoussame on 16/06/2017.
 */
public class ClientEntity implements Serializable, IEntity {
    private int idClient;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;
    private CourseSessionEntity courseSession;

    public ClientEntity(){}

    public ClientEntity(final String lastName, final String firstName, final String address, final String phone, final String email, final CourseSessionEntity courseSession) {
        this.lastname = lastName;
        this.firstname = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSession = courseSession;
    }


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSessionEntity getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSessionEntity courseSession) {
        this.courseSession = courseSession;
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
        builder.append(", courseSession=").append(courseSession.toString());
        builder.append("}");
        return builder.toString();
    }
}
