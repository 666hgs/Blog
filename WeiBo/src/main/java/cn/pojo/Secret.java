package main.java.cn.pojo;

public class Secret {
    private Integer id;
    private String user_tel;
    private Integer questionid;
    private String answer;
    private String question;


    public Secret() {
    }

    public Secret(String user_tel, Integer questionid, String answer) {
        this.user_tel = user_tel;
        this.questionid = questionid;
        this.answer = answer;
    }
    public Secret(Integer id, String user_tel, Integer questionid, String answer) {
        this.id = id;
        this.user_tel = user_tel;
        this.questionid = questionid;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "secret{" +
                "id=" + id +
                ", user_tel='" + user_tel + '\'' +
                ", questionid=" + questionid +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}


