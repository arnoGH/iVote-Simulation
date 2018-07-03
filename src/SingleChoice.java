// Single Choice Question Class

public class SingleChoice implements Question {
    String q = "default";
    String a = "default";

    public String question(){
        return q;
    }
    public String answer(){
        return a;
    }

    public void setQuestion(String q){
        this.q = q;
    }
    public void setAnswer(String a){
        this.a = a;
    }

    public boolean isMultipleChoice(){
        return false;
    }
}
