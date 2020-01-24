package lesson05.part03;

import java.io.*;

/**
 * Писатель в файл с консоли
 * 1. Прочесть с консоли имя файла.
 * 2. Считывать строки с консоли, пока пользователь не введет строку "exit".
 * 3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
 * <p>
 * <p>
 * Требования:
 * 1. Программа должна считывать c консоли имя файла.
 * 2. Создай и используй объект типа BufferedWriter.
 * 3. Программа не должна ничего читать из файловой системы.
 * 4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
 * 5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
 * 6. Метод main должен закрывать объект типа BufferedWriter после использования.
 * 7. Метод main не должен выводить данные на экран.
 */

public class Task19 {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String text=r.readLine();
        BufferedWriter w = new BufferedWriter(new FileWriter(text));

        while (!text.equals("exit")) {
            text=r.readLine();
            w.write(text);
            w.newLine();

        }
        r.close();
        w.close();


    }
}
