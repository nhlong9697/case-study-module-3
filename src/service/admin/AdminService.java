package service.admin;

import model.Program;

import java.util.List;

public interface AdminService {
    void add(Program program);

    List<Program> findAllProgram();

    Program findProgramById(int id);

    void remove(int id);
}
