package model;

import java.util.List;

public class Program {
    private int programId;
    private String programName;
    private List<Module> moduleList;

    public Program(int programId, String programName, List<Module> moduleList) {
        this.programId = programId;
        this.programName = programName;
        this.moduleList = moduleList;
    }

    public Program(int programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }
    public Program (String programName) {
        this.programName = programName;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }
}
