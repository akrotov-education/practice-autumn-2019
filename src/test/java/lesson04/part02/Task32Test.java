package lesson04.part02;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class Task32Test {
    @Test
    public void test1() {
        Set<Integer> set = Task32.createSet();
        Assert.assertTrue("Message", set.size() == 20);
    }
    @Test
    public void test2() {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 4; i < 24; i++) {
            set.add(i);
        }
        Task32.removeAllNumbersGreaterThan10(set);
        Assert.assertTrue("Message", set.size() == 7);
    }
}