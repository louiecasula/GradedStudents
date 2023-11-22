package io.zipcoder;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;
    public Student(String firstName, String lastName, ArrayList<Double> examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
        Iterator<Double> it = examScores.iterator();
        int i = 1;
        sb.append("Exam Scores:\n");
        while (it.hasNext()){
            sb.append("        Exam ").append(i).append(" -> ").append(it.next()).append("\n");
            i++;
        }
        return sb.toString();
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
        examScores.remove(examNumber - 1);
        examScores.add(examNumber - 1, newScore);
    }

    public double getAverageExamScore(){
        Iterator<Double> it = examScores.iterator();
        double sum = 0;
        while(it.hasNext()){
            sum += it.next();
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName +
                "\nAverage Score: " + getAverageExamScore() + "\n" +
                getExamScores();
    }
}
