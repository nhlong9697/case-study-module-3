package service.admin;

import model.Program;

import java.util.List;

public interface AdminService {
    void add(Program program);
    List<Program> findAllProgram();
}
