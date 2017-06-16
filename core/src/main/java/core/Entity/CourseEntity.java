package core.Entity;

import java.io.Serializable;

/**
 * Created by ennajihihoussame on 16/06/2017.
 */
public class CourseEntity implements Serializable, IEntity {
    private String codeCourse;
    private String title;

    public String getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

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
        builder.append("title=").append(title);
        builder.append(", code=").append(title);
        builder.append("}");
        return builder.toString();
    }
}
