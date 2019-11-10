package lesson04.part02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task31Test {
    @Test
    public void test1() {
        Assert.assertTrue("Message", (Task31.getListForAddOrInsert().getClass() + "")
                .contains("LinkedList"));
    }
    @Test
    public void test2() {
        Assert.assertTrue("Message", (Task31.getListForGet().getClass() + "")
                .contains("ArrayList"));
    }
    @Test
    public void test3() {
        Assert.assertTrue("Message", (Task31.getListForRemove().getClass() + "")
                .contains("LinkedList"));
    }
    @Test
    public void test4() {
        Assert.assertTrue("Message", (Task31.getListForSet().getClass() + "")
                .contains("ArrayList"));
    }
}