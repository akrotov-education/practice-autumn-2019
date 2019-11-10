package lesson04.part02;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Task28Test {
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("re");
        list.add("rtrt");
        Task28.insert10000(list);
        Assert.assertTrue("Message", list.size() == 10002);
        Task28.remove10000(list);
        Assert.assertTrue("Message", list.size() == 2);
    }
}