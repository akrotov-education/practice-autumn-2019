package lesson04.part03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task35Test {
    @Test
    public void test1() {
        Assert.assertTrue("Message", (Task35.method1()[1] + "").contains("method1"));
    }
    @Test
    public void test2() {
        Assert.assertTrue("Message", (Task35.method2()[1] + "").contains("method2"));
    }
    @Test
    public void test3() {
        Assert.assertTrue("Message", (Task35.method3()[1] + "").contains("method3"));
    }
    @Test
    public void test4() {
        Assert.assertTrue("Message", (Task35.method4()[1] + "").contains("method4"));
    }
    @Test
    public void test5() {
        Assert.assertTrue("Message", (Task35.method5()[1] + "").contains("method5"));
    }
}