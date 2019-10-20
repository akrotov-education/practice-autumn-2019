package main.java.lesson02.part02;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task01Test {

    @Test
    public void main() {
        Task01.Person person = new Task01.Person();
        person.adjustAge(person.age);
        int expected = 40;
        int actual = person.age;
        assertEquals(expected,actual);
    }
}