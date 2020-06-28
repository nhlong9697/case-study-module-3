package model;

import java.time.Duration;
import java.util.List;

public class Test {
    private int testId;
    private List<Question> questionList;
    private float mps;
    private Duration duration;

    public Test(int testId, List<Question> questionList, float mps, Duration duration) {
        this.testId = testId;
        this.questionList = questionList;
        this.mps = mps;
        this.duration = duration;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public float getMps() {
        return mps;
    }

    public void setMps(float mps) {
        this.mps = mps;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
