package io.zipcoder;

import java.util.*;

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
//        ArrayList<Student> sorted = new ArrayList<>(students);
//        Collections.sort(sorted);
//        return sorted;
        Collections.sort(students);
        return students;
    }

    public TreeMap<Student, String> getGradeBook(){
        TreeMap<Student, String> gradeBook = new TreeMap<>();
        Iterator<Student> i = students.iterator();
        while(i.hasNext()){
            int lowerThanCurrent = 0;
            Student current = i.next();
            Iterator<Student> j = getStudentsByScore().iterator();
            while(j.hasNext()){
                if (j.next().getAverageExamScore() < current.getAverageExamScore()){
                    lowerThanCurrent++;
                }
            }
            double percentile = 0.0;
            if (lowerThanCurrent == 0){
                percentile = 1.0;
            }
            else{
                percentile = (double) lowerThanCurrent / students.size() * 100;
            }
            if(percentile >= 90){
                gradeBook.put(current, "A");
            }
            else if(percentile >= 71){
                gradeBook.put(current, "B");
            }
            else if(percentile >= 50){
                gradeBook.put(current, "C");
            }
            else if(percentile >= 11){
                gradeBook.put(current, "D");
            }
            else{
                gradeBook.put(current, "F");
            }
        }
        return gradeBook;
    }
}
