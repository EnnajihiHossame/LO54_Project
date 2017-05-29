package core.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ennajihihoussame on 28/05/2017.
 */
@Entity
@Table(name = "COURSE_SESSION", schema = "LO54_database", catalog = "")
public class CourseSessionEntity implements Serializable, IEntity{
    private int idCourseSession;
    private Timestamp startDate;
    private Timestamp endDate;
    private String codeCourse;
    private int idLocation;

    @Id
    @Column(name = "ID_COURSE_SESSION", nullable = false)
    public int getIdCourseSession() {
        return idCourseSession;
    }

    public void setIdCourseSession(int idCourseSession) {
        this.idCourseSession = idCourseSession;
    }

    @Basic
    @Column(name = "START_DATE", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = false)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSessionEntity that = (CourseSessionEntity) o;

        if (idCourseSession != that.idCourseSession) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourseSession;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "CODE_COURSE", nullable = false, length = 45)
    public String getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

    @Basic
    @Column(name = "ID_LOCATION", nullable = false)
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseSession{");
        builder.append("id=").append(idCourseSession);
        builder.append(", startDate=").append(startDate);
        builder.append(", endDate=").append(endDate);
        builder.append(", course=").append(codeCourse);
        builder.append(", location=").append(idLocation);
        builder.append("}");
        return builder.toString();
    }
}
