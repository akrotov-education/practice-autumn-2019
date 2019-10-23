package lesson02.part01;

/**
 * Создать 5 зергов, 3 протосса и 4 террана.
 * Дать им всем уникальные имена.
 * <p>
 * <p>
 * Требования:
 * 1.	Нельзя изменять классы Zerg, Protoss и Terran.
 * 2.	Нужно создать 5 объектов типа Zerg и каждому из них дать свое имя.
 * 3.	Нужно создать 3 объекта типа Protoss и каждому из них дать свое имя.
 * 4.	Нужно создать 4 объекта типа Terran и каждому из них дать свое имя.
 */

public class Task07 {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg a = new Zerg();
        Zerg b = new Zerg();
        Zerg c = new Zerg();
        Zerg d = new Zerg();
        Zerg e = new Zerg();
        a.name = "a1";
        b.name = "b1";
        c.name = "c1";
        d.name = "d1";
        e.name = "e1";
        Protoss f = new Protoss();
        Protoss g = new Protoss();
        Protoss h = new Protoss();
        f.name = "f1";
        g.name = "g1";
        h.name = "h1";
        Terran i = new Terran();
        Terran j = new Terran();
        Terran k = new Terran();
        Terran l = new Terran();
        i.name = "i1";
        j.name = "j1";
        k.name = "k1";
        l.name = "l1";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
