/**
 * This file was generated by the Jeddict
 */
package futuretechschool.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Andreas N
 */
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "Education", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Course> courses;
    
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        getStudents().add(student);
        student.setEducation(this);
    }

    public void removeStudent(Student student) {
        getStudents().remove(student);
        student.setEducation(null);
    }

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Education)obj).getId();
    }
    
    public String toString() {
        return "Education " + " | id: " + id + "| name: " + name + " | courses: " + "\n" + courses;
    }

}