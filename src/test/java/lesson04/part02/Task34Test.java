package lesson04.part02;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class Task34Test {
    @Test
    public void test1() {
        Map<String, Integer> map = Task34.createMap();
        Assert.assertTrue("Message", map.size() == 10);
    }
    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Грибова", 560);
        map.put("Витев", 450);
        map.put("Жиева", 500);
        map.put("Ванева", 500);
        map.put("Укова", 390);
        map.put("Жукова", 620);
        map.put("Кыва", 980);
        map.put("Каин", 440);
        map.put("Финн", 320);
        map.put("Ивева", 1100);
        Task34.removeItemFromMap(map);
        Assert.assertTrue("Message", map.size() == 6);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            Assert.assertTrue("Message", map.get(key) >= 500);
        }
    }
}