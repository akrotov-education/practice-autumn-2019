package Main;

public class Task06 {

    /**
     * ������ �� ����� ����� ����������, ������������ �� �������: L = 2 * Pi * radius.
     * ��������� - ������� ����� (��� double).
     * � �������� �������� Pi ��������� �������� 3.14.
     * <p>
     * <p>
     * ����������:
     * 1. � ������ printCircleLength ����� ������� ����� ����������, ������������ �� �������: 2 * Pi * radius.
     * 2. ����� main ������ �������� ����� printCircleLength � ���������� 5.
     * 3. ����� main �� ������ �������� ������� ������ ������ �� �����.
     * 4. ��������� ������ �������� ����� ���������� � �������� 5.
     */

    public static void task() {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        //�������� ��� ��� ���
    	System.out.print((2 * Math.PI * radius));
    }
}
