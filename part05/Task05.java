package lesson05.part05;

import java.util.ArrayList;
import java.util.List;

/**
 * ООП - исправь ошибки в наследовании
 * Исправь метод containsBones и всю связанную с ним логику так, чтобы:
 * 1. Поведение программы осталось прежним.
 * 2. Метод containsBones должен возвращать тип Object и значение "Yes" вместо true, "No" вместо false
 * <p>
 * <p>
 * Требования:
 * 1. Метод containsBones в классе BodyPart должен иметь тип возвращаемого значения Object.
 * 2. Класс Finger должен быть потомком класса BodyPart.
 * 3. Метод containsBones в классе Finger должен иметь тип возвращаемого значения Object.
 * 4. Метод containsBones в классе BodyPart должен возвращать строку "Yes".
 * 5. Метод containsBones в классе Finger должен возвращать строку "Yes", если метод containsBones в классе BodyPart возвращает "Yes" и флаг isArtificial равен false, если приведенное условие не выполняется - вернуть "No".
 * 6. Метод toString в классе BodyPart должен возвращать строку формата "name(имя части тела) содержит кости", если метод containsBones возвращает "Yes" для этой части тела, а если "No", то строку формата "name(имя части тела) не содержит кости".
 */

public class Task05 {
    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnLivingParts();
    }

    private static void printlnLivingParts() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }

    public interface LivingPart {
        Object containsBones();
    }

    public static class BodyPart implements LivingPart {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public Object containsBones() {
            return "Yes";
        }

        public String toString() {
            return containsBones().equals("Yes") ? name + " содержит кости" : name + " не содержит кости";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }

        public Object containsBones() {
            return super.containsBones().equals("Yes") && !isArtificial ? "Yes":"No";
        }
    }
}

