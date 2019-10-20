package lesson02.part01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Task07.class)
public class Task07Test {

    static int zergCount = 0;
    static int protossCount = 0;
    static  int terranCount = 0;

    @Test
    public void testZerg()
    {
        //TODO: only parsing
        try {
            PowerMockito.mockStatic(Task07.Zerg.class);
            Task07.Zerg[] zergMocks = new Task07.Zerg[5];

            PowerMockito.whenNew(Task07.Zerg.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                    Task07.Zerg z = new Task07.Zerg();
                    zergMocks[zergCount] = z;
                    zergCount++;
                    return z;
                }
            });

            Task07.main(null);

            for (Task07.Zerg z: zergMocks) {
                Assert.assertNotEquals(null, z);
                Assert.assertNotEquals(null, z.name);
            }

        }
        catch (Exception e)
        {
            Assert.fail("c zerg что-то явно не так");
        }
    }

    @Test
    public void testProtoss()
    {
        //TODO: only parsing
        try {
            PowerMockito.mockStatic(Task07.Protoss.class);
            Task07.Protoss[] protossMocks = new Task07.Protoss[3];

            PowerMockito.whenNew(Task07.Protoss.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                    Task07.Protoss p = new Task07.Protoss();
                    protossMocks[protossCount] = p;
                    protossCount++;
                    return p;
                }
            });

            Task07.main(null);

            for (Task07.Protoss p: protossMocks) {
                Assert.assertNotEquals(null, p);
                Assert.assertNotEquals(null, p.name);
            }

        }
        catch (Exception e)
        {
            Assert.fail("c ptotos что-то явно не так");
        }
    }

    @Test
    public void testTerran()
    {
        //TODO: only parsing
        try {
            PowerMockito.mockStatic(Task07.Terran.class);
            Task07.Terran[] terranMocks = new Task07.Terran[4];

            PowerMockito.whenNew(Task07.Terran.class).withNoArguments().thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

                    Task07.Terran t = new Task07.Terran();
                    terranMocks[terranCount] = t;
                    terranCount++;
                    return t;
                }
            });

            Task07.main(null);

            for (Task07.Terran p: terranMocks) {
                Assert.assertNotEquals(null, p);
                Assert.assertNotEquals(null, p.name);
            }

        }
        catch (Exception e)
        {
            Assert.fail("c terran что-то явно не так");
        }
    }
}