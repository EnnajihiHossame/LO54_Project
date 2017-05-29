package core.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ennajihihoussame on 28/05/2017.
 */
@Entity
@Table(name = "COURSE", schema = "LO54_database", catalog = "")
public class CourseEntity implements Serializable, IEntity{
    private String codeCourse;
    private String title;

    @Id
    @Column(name = "CODE_COURSE", nullable = false, length = 45)
    public String getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (codeCourse != null ? !codeCourse.equals(that.codeCourse) : that.codeCourse != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeCourse != null ? codeCourse.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Course{");
        builder.append("codeCourse=").append(codeCourse);
        builder.append(", title=").append(title);
        builder.append("}");
        return builder.toString();
    }
}
