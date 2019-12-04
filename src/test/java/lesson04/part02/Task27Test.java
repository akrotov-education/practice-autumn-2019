package lesson04.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

@RunWith(JUnit4.class)
public class Task27Test {

    @Before
    public void setUp() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void tearDown() throws Exception {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void checkNoOutput() {
        Task27.main(null);

        ByteArrayOutputStream output = SystemOutGatewayUtil.getOutputArray();
        Assert.assertTrue("Program mustn't display any text",
                output.size() == 0
        );
    }

    @Test
    public void checkMethodsCount() {
        Assert.assertEquals("Program must contains only 3 methods",
                3,
                Task27.class.getDeclaredMethods().length
        );
    }

    @Test
    public void checkCreateArrayList() {
        Object arrayList = Task27.createArrayList();
        Assert.assertTrue("Method createArrayList must create and return ArrayList",
                arrayList instanceof ArrayList
        );
    }

    @Test
    public void checkCreateLinkedList() {
        Object arrayList = Task27.createLinkedList();
        Assert.assertTrue("Method createLinkedList must create and return LinkedList",
                arrayList instanceof LinkedList
        );
    }
}