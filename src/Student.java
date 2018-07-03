// Student Class
// Holds information about the student (their unique ID and answer they picked)

public class Student {

    private String sID;
    private String answer;

    public Student(){
        this.sID = "default";
        this.answer = "default";
    }

    public void setID(String sID){
        this.sID = sID;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getID(){
        return sID;
    }

    public String getAnswer(){
        return answer;
    }
}
