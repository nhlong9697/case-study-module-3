package model;

import java.util.List;

public class Module {
    private int moduleId;
    private String moduleName;
    private List<Question> questionList;

    public Module(int moduleId, String moduleName, List<Question> questionList) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.questionList = questionList;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
