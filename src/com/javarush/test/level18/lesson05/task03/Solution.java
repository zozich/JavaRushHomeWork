package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileInput = reader.readLine();
        String fileOutput1 = reader.readLine();
        String fileOutput2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileInput);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileOutput1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileOutput2);
        int count = 0;

        while (fileInputStream.available() != 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            if (buffer.length % 2 == 0) {
                count = buffer.length / 2;
            } else {
                count = buffer.length / 2 + 1;
            }
            fileInputStream.read(buffer);
            fileOutputStream1.write(buffer, 0, count);
            fileOutputStream2.write(buffer, count, buffer.length - count);
        }

        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
