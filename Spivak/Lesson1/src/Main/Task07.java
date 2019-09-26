package Main;

public class Task07 {

    /**
     * ����� convertCelsiusToFahrenheit(int celsius) ��������� �������� � �������� �������. ����� ������ ���������� ����������� � ���������� �������� � �������� ����������.
     * ����������� �� ������� TC � ����������� �� ���������� TF ������� ��������� ������������:
     * TF = (9 / 5) * TC + 32
     * <p>
     * ������:
     * � ����� convertCelsiusToFahrenheit �� ���� �������� �������� 41.
     * <p>
     * ������ ������:
     * 105.8
     * <p>
     * <p>
     * ����������:
     * 1. ����� convertCelsiusToFahrenheit(int) ������ ���� ��������� � �����������.
     * 2. ����� convertCelsiusToFahrenheit ������ ���������� �������� ���� double.
     * 3. ����� convertCelsiusToFahrenheit �� ������ ������ �������� �� �����.
     * 4. ����� convertCelsiusToFahrenheit ������ ��������� ���������� ������� ������� � ������� ���������� � ���������� ��� �����.
     */

    public static void task() {
        System.out.println(convertCelsiusToFahrenheit(41));
    }

    public static double convertCelsiusToFahrenheit(int celsius) {
        //�������� ��� ��� ���
    	double TF = (9. / 5) * celsius + 32;
        return TF;
    }
}