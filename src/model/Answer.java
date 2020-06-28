package model;

public class Answer {
    private int answerId;
    private String answer;
    private boolean status;

    public Answer(int answerId, String answer, boolean status) {
        this.answerId = answerId;
        this.answer = answer;
        this.status = status;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
