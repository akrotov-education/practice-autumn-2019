package lesson02.part02;

import lesson02.part01.Task16;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task01Test {
    @Test
    public void test1 () {
        Task01.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("Age in adjustAge() is:"));
    }

    @Test
    public void test2 () {
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Task01.Person pers = new Task01.Person();
        pers.age = 56;
        pers.adjustAge(pers.age);
        Assert.assertTrue("Message", pers.age == 76);
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemOutGatewayUtil.getOutputArray();
    }
}