package Main;

public class Task04 {

    /**
     * �������������� ���� �������, ����� ��������� ������ �� ����� ����� 26 � 25.
     * <p>
     * ����������:
     * 1. ��������� ������ �������� �� ����� ����� 12 � 2.
     * 2. ����� ����������������� ���� ������.
     * 3. ������ �������� (���������, �������) ������ � �����.
     */

    public static void task() {

        int x = 27;
        int y = 15;

        // y = x - y;
        // y = y - x;
        // y = y + x;
        // y = y + x;
        y = x / y;
        // y = y / x;
        // y = y * x;

        x = x - y;
        y = y - x;

        System.out.println(Math.abs(x));
        System.out.println(Math.abs(y));
    }
}