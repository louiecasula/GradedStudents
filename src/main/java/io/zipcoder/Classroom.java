package io.zipcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Classroom {
    ArrayList<Student> students;
    int maxNumberOfStudents;
    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(ArrayList<Student> students){
        this.students = students;
    }

    public Classroom(){
        this.maxNumberOfStudents = 30;
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public Double getAverageExamScore(){
        Iterator<Student> it = students.iterator();
        double sum = 0.0;
        while (it.hasNext()){
            sum += it.next().getAverageExamScore();
        }
        return sum / students.size();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(String firstName, String lastName){
        for (Student s: students){
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                this.students.remove(s);
            }
        }
    }

    public ArrayList<Student> getStudentsByScore(){
        return new ArrayList<Student>();
    }

    public TreeMap<Student, String> getGradeBook(){
        return new TreeMap<>();
    }
}
