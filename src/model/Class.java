package model;

import java.util.List;

public class Class {
    private String className;
    private List<Student> students;

    public Class(String className, List<Student> students) {
        this.className = className;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
