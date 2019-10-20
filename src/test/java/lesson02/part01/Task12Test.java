package lesson02.part01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task12Test {
    @Test
    public void test1 () {
        Task12.main(null);
        ByteArrayOutputStream outputArray = SystemOutGatewayUtil.getOutputArray();
        String s = outputArray.toString();
        Assert.assertTrue("Message", s.contains("МылаРамуМама"));
        Assert.assertTrue("Message", s.contains("РамуМамаМыла"));
        Assert.assertTrue("Message", s.contains("МылаМамаРаму"));
        Assert.assertTrue("Message", s.contains("РамуМылаМама"));
        Assert.assertTrue("Message", s.contains("МамаМылаРаму"));
        Assert.assertTrue("Message", s.contains("МамаРамуМыла"));
        Assert.assertTrue("Message", s.split("\n").length == 6);
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