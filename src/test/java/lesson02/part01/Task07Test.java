package test.java.lesson02.part01;

import static org.junit.Assert.*;

import main.java.lesson02.part01.Task07;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.Assert;

@RunWith(JUnit4.class)
public class Task07Test {

	@Test
	public void test() {
		try {
			Assert.assertEquals(Task07.Protoss.class.getDeclaredFields().length, 1);
			Assert.assertEquals(Task07.Terran.class.getDeclaredFields().length, 1);
			Assert.assertEquals(Task07.Zerg.class.getDeclaredFields().length, 1);
		}catch(Exception e){
			Assert.fail("Классы изменять нельзя");
		}

	}

}
