package main.java.lesson02.part02;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class Task43Test {

    @Test
    public void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "Bob";
        int bYear = 1990;
        int bMonth = 6;
        int bDay = 10;

        String expected = "Меня зовут Bob";
        String expected1 = "Я родился 10.6.1990";
        String actual = ("Меня зовут " + name);
        String actual1 = ("Я родился " + bDay + "." + bMonth + "." + bYear);
        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + bDay + "." + bMonth + "." + bYear);
        assertEquals(expected,actual);
        assertEquals(expected1,actual1);

    }
}