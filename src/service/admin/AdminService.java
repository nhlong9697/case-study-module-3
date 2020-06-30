package service.admin;

import model.Program;
import model.ProgramClass;

import java.util.List;

public interface AdminService {
    void addProgram(Program program);

    List<Program> findAllProgram();

    Program findProgramById(int id);

    void removeProgram(int id);

    void editProgram(Program program);

    void addClass(ProgramClass newClass);

    List<ProgramClass> findAllClass(int programId);
}
