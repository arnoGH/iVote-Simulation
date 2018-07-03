// Simulation Driver Class
// Generates Students, Question, and the Students' Answers

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

    private static Random r = new Random();
    private static Student students[];
    private static Question q;

    // main method to kick start everything
    public static void main(String[] args) {
        students = createStudents();

        int num = r.nextInt((100-1)+1) + 1;

        // pick if it will be a multiple choice question or single choice
        if (num % 2 == 0) {
            q = new MultipleChoice();
            multiple();
        }
        else {
            q = new SingleChoice();
            single();
        }

        IVoteService v = new IVoteService(students, q);
    }

    private static void multiple(){ // answers for multiple choice question
        String answers[] = {"A", "B", "C", "D"};
        q.setQuestion("Choose the correct multiple choice answer");
        int index = r.nextInt(4);
        q.setAnswer(answers[index]); // set correct answer to the question

        for (Student i : students) { // assign an answer to each student
            index = r.nextInt(4);
            i.setAnswer(answers[index]);
        }
    }


    private static void single(){ // answers for single choice question
        q.setQuestion("Write the correct answer");
        q.setAnswer("Right"); // set correct answer to the question

        int index = 0;
        for (Student i : students) { // assign an answer to each student
            index = r.nextInt(3);
            if (index % 2 == 0)
                i.setAnswer("Right");
            else
                i.setAnswer("Wrong");
        }
    }

    // generate X number of students with unique IDs
    private static Student[] createStudents(){
        int numOfStudents = r.nextInt(100-30) + 30; // generate number of students between 30 - 100

        Student students[] = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) { // initiate all student objects
            students[i] = new Student();
        }

        List<String> idNumbers= new ArrayList<>(); // holds all unique student IDs

        for (Student i : students) { // traverse array and assign each student a unique ID
            i.setID(Integer.toString(r.nextInt(9999-1000) + 1000));
            while (idNumbers.contains(i.getID())){ // make sure that no duplicate IDs
                i.setID(Integer.toString(r.nextInt(9999-1000) + 1000));
            }
            idNumbers.add(i.getID());
        }

        return students;
    }
}
