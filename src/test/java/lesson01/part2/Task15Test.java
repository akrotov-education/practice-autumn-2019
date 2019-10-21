package lesson01.part2;

import lesson01.part1.Task01;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task15Test {
    @Before
    public void before(){
        SystemOutGatewayUtil.setCustomOut();

    }

    @After
    public void after() {
        SystemOutGatewayUtil.setOriginalOut();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test15_1() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("не пройдено 1е условие!",collect.get(25).contains("Man ") && collect.get(25).contains("= new Man();")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15_2() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("не пройдено 2е условие!",collect.get(26).contains("Woman ") && collect.get(26).contains("= new Woman();")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15_3() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("не пройдено 3е условие!",collect.get(28).contains(".wife =")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15_4() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("не пройдено 4е условие!",collect.get(29).contains(".husband =")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15_5() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue("не пройдено 5е условие!",
                    collect.get(33).contains("public int age") &&
                            collect.get(34).contains("public int height") &&
                            collect.get(35).contains("public Woman wife")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test15_6() {
        Task15.main(null);
        String fileName="./src/main/java/lesson01/part2/Task15.java";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> collect = stream.collect(Collectors.toList());
            Assert.assertTrue(  "не пройдено 6е условие!",
                    collect.get(39).contains("public int age") &&
                            collect.get(40).contains("public int height") &&
                            collect.get(41).contains("public Man husband")   );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}