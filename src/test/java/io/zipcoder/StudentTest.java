package io.zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;
    Student student;
    @Before
    public void setup() throws Exception{
        firstName = "Barry";
        lastName = "Allen";
        examScores = new ArrayList<>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        student = new Student(firstName, lastName, examScores);
    }

    @After
    public void tearDown() throws Exception{
        examScores.clear();
    }

    @Test
    public void testGetFirstName() {
        Assert.assertEquals("Barry", student.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        student.setFirstName("Eobard");
        Assert.assertEquals("Eobard", student.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Assert.assertEquals("Allen", student.getLastName());
    }

    @Test
    public void testSetLastName() {
        student.setLastName("Thawne");
        Assert.assertEquals("Thawne", student.getLastName());
    }

    @Test
    public void testGetExamScores() {
        String expected = "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                "        Exam 2 -> 95.0\n" +
                "        Exam 3 -> 123.0\n" +
                "        Exam 4 -> 96.0\n";
        Assert.assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        Assert.assertEquals(4, student.getNumberOfExamsTaken());
    }

    @Test
    public void testAddExamScore() {
        student.addExamScore(100.0);
        String expected = "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                "        Exam 2 -> 95.0\n" +
                "        Exam 3 -> 123.0\n" +
                "        Exam 4 -> 96.0\n" +
                "        Exam 5 -> 100.0\n";
        Assert.assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testSetExamScore() {
        student.setExamScore(2, 100);
        String expected = "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                "        Exam 2 -> 100.0\n" +
                "        Exam 3 -> 123.0\n" +
                "        Exam 4 -> 96.0\n";
        Assert.assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testGetAverageExamScore() {
        Assert.assertEquals(103.5, student.getAverageExamScore(),0);
    }

    @Test
    public void testTestToString() {
        String expected = "Student Name: Barry Allen\n" +
                "Average Score: 103.5\n" +
                "Exam Scores:\n" +
                "        Exam 1 -> 100.0\n" +
                "        Exam 2 -> 95.0\n" +
                "        Exam 3 -> 123.0\n" +
                "        Exam 4 -> 96.0\n";
        Assert.assertEquals(expected, student.toString());
    }
}