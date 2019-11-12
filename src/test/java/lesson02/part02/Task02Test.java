package lesson02.part02;

import lesson02.part01.Task16;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class Task02Test {
    @Test
    public void test1 () {
        Task02.main(null);
        Assert.assertTrue("Message",  Task02.Apple.applesPrice != 0);
    }

    @Test
    public void test2 () {
        Task02.Apple.addPrice(849);
        Task02.Apple.addPrice(113);
        Assert.assertTrue("Message", Task02.Apple.applesPrice == 962);
    }
}