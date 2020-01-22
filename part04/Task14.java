package lesson05.part04;

import java.util.ArrayList;
import java.util.List;

/**
 * Клининговый центр
 * 1. Реализовать метод cleanAllApartments.
 * Для каждого объекта из apartments:
 * 2. Для однокомнатных квартир (OneRoomApt) вызвать метод clean1Room.
 * т.е. если объект типа OneRoomApt, то вызвать у него метод clean1Room.
 * 3. Для двухкомнатных квартир (TwoRoomApt) вызвать метод clean2Rooms
 * т.е. если объект типа TwoRoomApt, то вызвать у него метод clean2Rooms.
 * 4. Для трехкомнатных квартир (ThreeRoomApt) вызвать метод clean3Rooms
 * т.е. если объект типа ThreeRoomApt, то вызвать у него метод clean3Rooms.
 * <p>
 * <p>
 * Требования:
 * 1. Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
 * 2. В методе cleanAllApartments для всех однокомнатных аппартаментов(OneRoomApt) содержащихся в списке необходимо вызвать метод clean1Room.
 * 3. В методе cleanAllApartments для всех двухкомнатных аппартаментов(TwoRoomApt) содержащихся в списке необходимо вызвать метод clean2Rooms.
 * 4. В методе cleanAllApartments для всех трехкомнатных аппартаментов(ThreeRoomApt) содержащихся в списке необходимо вызвать метод clean3Rooms.
 * 5. Классы OneRoomApt, TwoRoomApt, ThreeRoomApt должны поддерживать(реализовывать) интерфейс Apartment.
 */

public class Task14 {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (Apartment ap : apartments) {
            if (ap instanceof OneRoomApt) {
                ((OneRoomApt) ap).clean1Room();
            } else if (ap instanceof TwoRoomApt) {
                ((TwoRoomApt) ap).clean2Rooms();
            } else if (ap instanceof ThreeRoomApt) {
               ((ThreeRoomApt) ap).clean3Rooms();
            }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
