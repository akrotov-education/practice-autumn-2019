package Main;

public class Task08 {

    /**
     * �������� ����� getMetreFromCentimetre(int centimetre).
     * ����� �� ���� ��������� ���������� �����������.
     * ����� ������� ���, ����� ����� ��������� ����� ������ ������ � centimetre. (1 ���� = 100 ��).
     * <p>
     * ������:
     * ����� getMetreFromCentimetre ���������� � ���������� 243.
     * <p>
     * ������ ������:
     * 2
     * <p>
     * <p>
     * ����������:
     * 1. ��������� �� ������ ��������� ������ � ����������.
     * 2. ����� getMetreFromCentimetre(int) ������ ���� ��������� � �����������.
     * 3. ����� getMetreFromCentimetre ������ ���������� �������� ���� int.
     * 4. ����� getMetreFromCentimetre �� ������ ������ �������� �� �����.
     * 5. ����� getMetreFromCentimetre ������ ��������� ���������� ���������� ������ ������ � centimetre.
     */

    public static void task() {
        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        //�������� ��� ��� ���
        return centimetre / 100;
    }
}
