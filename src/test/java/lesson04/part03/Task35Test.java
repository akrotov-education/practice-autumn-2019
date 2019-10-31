package lesson04.part03;
//@FoLoKe
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task35Test {
    /* 1.	В классе должно быть 5 методов (метод main не учитывать).
     * 2.	Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
     * 3.	Каждый метод должен возвращать свой StackTrace.
     * 4.	Для получения StackTrace воспользуйся Thread.currentThread().getStackTrace().
     */

    @Test
    public void test35main() {
        Task35.main(null);
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            System.out.println(e);
        }
        System.out.println();
    }

    @Test
    public void test3501() {

    }

    @Test
    public void test3502() {

    }

    @Test
    public void test3503() {

    }

    @Test
    public void test3504() {

    }
}