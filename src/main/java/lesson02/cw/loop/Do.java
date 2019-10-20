package lesson02.cw.loop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Do {

    public int aa;
    public static AtomicInteger bb;

    public class A {
        int a;
    }

    public static class B {}

    public static void main(String[] args) {
        System.out.println();

        A a = new Do().new A();
        B b = new B();

        class C {}

        ArrayList<Object> objects = new ArrayList<>();

        Collections.sort(objects, new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.equals(o2) ? 0 : 1;
                    }
                }
                );
    }


    public static void setB () {

        System.out.println(bb.incrementAndGet());
    }

}
