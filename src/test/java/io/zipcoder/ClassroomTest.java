package io.zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {
    Classroom classroom;
    @Before
    public void setup(){
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(80.0));
        ArrayList<Double> examScores2 = new ArrayList<>(Arrays.asList(60.0));
        ArrayList<Double> examScores3 = new ArrayList<>(Arrays.asList(100.0));
        ArrayList<Double> examScores4 = new ArrayList<>(Arrays.asList(80.0));
        ArrayList<Double> examScores5 = new ArrayList<>(Arrays.asList(80.0));
        Student student1 = new Student("Otto", "Octavius", examScores1);
        Student student2 = new Student("Flint", "Marko", examScores2);
        Student student3 = new Student("Norman", "Osborne", examScores3);
        Student student4 = new Student("Max", "Dillon", examScores4);
        Student student5 = new Student("Cletus", "Cassidy", examScores5);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        classroom = new Classroom(students);
    }

    @After
    public void tearDown(){
        classroom.students.clear();
    }

    @Test
    public void testGetStudents() {
        String expected = "[Student Name: Otto Octavius\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                ", Student Name: Flint Marko\n" +
                "Average Score: 60.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 60.0\n" +
                ", Student Name: Norman Osborne\n" +
                "Average Score: 100.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                ", Student Name: Max Dillon\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                ", Student Name: Cletus Cassidy\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                "]";
        Assert.assertEquals(expected, classroom.getStudents().toString());
    }

    @Test
    public void testGetAverageExamScore() {
        Double expected = 80.0;
        Assert.assertEquals(expected,classroom.getAverageExamScore());
    }

    @Test
    public void testAddStudent() {
        ArrayList<Double> examScores6 = new ArrayList<>(Arrays.asList(70.0));
        Student student6 = new Student("Aleksei", "Sytsevich", examScores6);
        classroom.addStudent(student6);

        Assert.assertEquals(6, classroom.students.size());
    }

    @Test
    public void testRemoveStudent() {
        classroom.removeStudent("Flint", "Marko");
        Assert.assertEquals(4, classroom.students.size());
    }

    @Test
    public void testGetStudentsByScore() {
        String expected = "[Student Name: Norman Osborne\n" +
        "Average Score: 100.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                ", Student Name: Cletus Cassidy\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                ", Student Name: Max Dillon\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                ", Student Name: Otto Octavius\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                ", Student Name: Flint Marko\n" +
                "Average Score: 60.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 60.0\n" +
                "]";
        Assert.assertEquals(expected, classroom.getStudentsByScore().toString());
    }

    @Test
    public void testGetGradeBook() {
        String expected = "Student Name: Flint Marko\n" +
                "Average Score: 60.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 60.0\n" +
                "Grade: D\n" +
                "Student Name: Otto Octavius\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                "Grade: B\n" +
                "Student Name: Max Dillon\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                "Grade: B\n" +
                "Student Name: Cletus Cassidy\n" +
                "Average Score: 80.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 80.0\n" +
                "Grade: B\n" +
                "Student Name: Norman Osborne\n" +
                "Average Score: 100.0\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                "Grade: A\n";
        StringBuilder sb = new StringBuilder();
        TreeMap<Student, String> gradeBook = classroom.getGradeBook();
        for (Student key: gradeBook.keySet()){
            sb.append(key).append(gradeBook.get(key)).append("\n");
        }
        String actual = sb.toString();
        Assert.assertEquals(expected, actual);
    }
}
