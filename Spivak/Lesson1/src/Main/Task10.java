package Main;

import java.time.LocalTime;

public class Task10 {

    /**
     * �� ������ � ���������
     * ������ ���, ������� ������� ������� ������ ������ � 15:00, ���� �� ����� 15:30. ������ ��������� �� �����.
     * <p>
     * <p>
     * ����������:
     * 1. ��������� ������ �������� �����.
     * 2. ���������� ����� ������ ���� ����� ������������� ������.
     * 3. ���������� ����� ������ ���� ������ 60.
     * 4. ��������� ����� ������ ��������������� �������.
     */

	public static void task() {
		int secondsAfter15 = 0;
        secondsAfter15 = (LocalTime.of(15, 30).getMinute() - LocalTime.of(15, 0).getMinute()) * 60;
        System.out.println(secondsAfter15);
	}
}
