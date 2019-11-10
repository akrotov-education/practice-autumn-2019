package lesson04.part01;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Task13Test {
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("мимоза");
        list.add("лимон");
        list.add("лор");
        list.add("ворота");
        ArrayList<String> resultList = Task13.fix(list);
        String[] result = {"мимоза", "лимон", "лор", "ворота"};
        int[] count = {1, 2, 1, 0};
        int[] countTest = {0, 0, 0, 0};
        for(int i = 0; i < resultList.size(); i++) {
            if(Arrays.asList(result).indexOf(resultList.get(i)) != -1)
                countTest[Arrays.asList(result).indexOf(resultList.get(i))] ++;
        }
        for(int i = 0; i < count.length; i++) {
            Assert.assertTrue("Message", count[i] == countTest[i]);
        }
    }

}