package service.admin;

import model.ProgramClass;
import model.Student;

import java.util.List;

public interface AdminStudentService {
    void addStudent(Student newStudent);

    List<Student> findAllStudentOfAClass(int classId);

    Student findStudentById(int id);

    void removeStudentById(int id);
}
