package lesson02.part02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task07Test {
    @Test
    public void test1 () {
        Task07.main(null);
        Assert.assertTrue("Message", Task07.Cat.count == 2);
    }
}