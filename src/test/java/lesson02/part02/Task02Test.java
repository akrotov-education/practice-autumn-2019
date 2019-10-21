package lesson02.part02;

import lesson02.part02.Task02;

import org.junit.Assert;

import org.junit.Test;


public class Task02Test {
    @Test
    public void test1 () {
        Task02.main(null);
        Assert.assertTrue("Message",  Task02.Apple.applesPrice != 0);
        Assert.assertTrue("Message", Task02.Apple.applesPrice == 150);
    }

}