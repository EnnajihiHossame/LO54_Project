package core.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ennajihihoussame on 16/06/2017.
 */
public class CourseSessionEntity implements Serializable, IEntity {
    private int idCourseSession;
    private Timestamp startDate;
    private Timestamp endDate;
    private CourseEntity course;
    private LocationEntity location;



    public int getIdCourseSession() {
        return idCourseSession;
    }

    public void setIdCourseSession(int idCourseSession) {
        this.idCourseSession = idCourseSession;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseSession{");
        builder.append("id=").append(idCourseSession);
        builder.append(", startDate=").append(startDate);
        builder.append(", endDate=").append(endDate);
        builder.append(", course=").append(course.toString());
        builder.append(", location=").append(location.toString());
        builder.append("}");
        return builder.toString();
    }
}
