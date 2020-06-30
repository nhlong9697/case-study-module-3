package model;

import java.util.List;

public class ProgramClass {
    private int classId;
    private String className;
    private int programId;
    private List<Student> students;

    public ProgramClass(int classId, String className, List<Student> students) {
        this.classId = classId;
        this.className = className;
        this.students = students;
    }

    public ProgramClass(String className, int programId) {
        this.className = className;
        this.programId = programId;
    }

    public ProgramClass(int classId, String className, int programId) {
        this.classId = classId;
        this.className = className;
        this.programId = programId;
    }

    public ProgramClass(String className) {
       this.className = className;
    }

    public ProgramClass(int classId, String className) {
        this.classId = classId;
        this.className = className;
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


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
}
