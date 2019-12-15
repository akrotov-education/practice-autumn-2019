package lesson05.part01;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task22Test {
    @Test
    public void t1(){/*впишите свои числа */
        Class[] a =Task22.class.getClasses();
        boolean w=false;
        for (Class q:a
             ) {    if(q.toString().contains("ChessFigure"))
                    w=true;
        }
        Assert.assertTrue(   "Не пройдено 1 условие",w );

           }
    @Test
    public void t2(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 2 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.King.class ));
    }
    @Test
    public void t3(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 3 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.Queen.class ));
           }
    @Test
    public void t4(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 4 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.Rook.class ));
       }
    @Test
    public void t5(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 5 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.Knight.class ));
           }
    @Test
    public void t6(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 6 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.Bishop.class ));
        }
    @Test
    public void t7(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 7 условие",Task22.ChessFigure.class.isAssignableFrom(Task22.Pawn.class ));

    }
}