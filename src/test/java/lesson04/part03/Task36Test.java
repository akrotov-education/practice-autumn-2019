package lesson04.part03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task36Test {
    @Test
    public void test1() {
        Assert.assertTrue("Message", (Task36.method1() + "").contains("test1"));
    }
    @Test
    public void test2() {
        Assert.assertTrue("Message", (Task36.method2() + "").contains("test2"));
    }
    @Test
    public void test3() {
        Assert.assertTrue("Message", (Task36.method3() + "").contains("test3"));
    }
    @Test
    public void test4() {
        Assert.assertTrue("Message", (Task36.method4() + "").contains("test4"));
    }
    @Test
    public void test5() {
        Assert.assertTrue("Message", (Task36.method5() + "").contains("test5"));
    }
}