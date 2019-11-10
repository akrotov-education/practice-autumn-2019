package lesson04.part03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task37Test {
    @Test
    public void test1() {
        Assert.assertTrue("Message", Task37.method1() == 11);
    }
    @Test
    public void test2() {
        Assert.assertTrue("Message", Task37.method2() == 15);
    }
    @Test
    public void test3() {
        Assert.assertTrue("Message", Task37.method3() == 19);
    }
    @Test
    public void test4() {
        Assert.assertTrue("Message", Task37.method4() == 23);
    }
    @Test
    public void test5() {
        Assert.assertTrue("Message", Task37.method5() == 27);
    }
}