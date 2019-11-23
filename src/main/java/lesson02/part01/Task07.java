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
        Zerg zerg1 = new Zerg(); zerg1.name=("Alex");
        Zerg zerg2 = new Zerg(); zerg2.name = ("Boris");
        Zerg zerg3 = new Zerg(); zerg3.name = ("Victor");
        Zerg zerg4 = new Zerg(); zerg4.name = ("Gregor");
        Zerg zerg5 = new Zerg(); zerg5.name = ("Darya");
        Protoss protos1 = new Protoss(); protos1.name = ("Egor");
        Protoss protos2 = new Protoss(); protos2.name = ("Jeri");
        Protoss protos3 = new Protoss(); protos3.name = ("Zerg");
        Terran terran1 = new Terran(); terran1.name = ("Ikarus");
        Terran terran2 = new Terran(); terran2.name = ("Kali");
        Terran terran3 = new Terran(); terran3.name = ("Largus");
        Terran terran4 = new Terran(); terran4.name = ("Mimimi");
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
