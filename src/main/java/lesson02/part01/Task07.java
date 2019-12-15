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
        Zerg Mihsa= new Zerg();
        Zerg Mihsa4= new Zerg();
        Zerg Mihsa5= new Zerg();
        Zerg Mihsa2= new Zerg();
        Zerg Mihsa3= new Zerg();
        Protoss Bob = new Protoss();
        Protoss Bob2 = new Protoss();
        Protoss Bob3 = new Protoss();
        Terran Vova = new Terran();
        Terran Vova2 = new Terran();
        Terran Vova3 = new Terran();
        Terran Vova4 = new Terran();


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
