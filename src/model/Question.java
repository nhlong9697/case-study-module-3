package model;

import java.util.List;

public class Question {
    private int questionId;
    private String question;
    private QuestionType type;
    private Level level;
    private List<Answer> answerList;

    public Question(int questionId, String question, Level level, List<Answer> answerList) {
        this.questionId = questionId;
        this.question = question;
        this.level = level;
        this.answerList = answerList;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
