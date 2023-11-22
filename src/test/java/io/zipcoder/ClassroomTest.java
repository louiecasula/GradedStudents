package io.zipcoder;

import org.junit.Test;

import java.util.Random;

public class ClassroomTest {
    @Test
    public void poo(){
        Random random = new Random();
        int choice = random.nextInt(3) + 1;
        System.out.println(choice);
    }
}
