package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int countAll = fileInputStream.available();
        int spaces = 0;

        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            if (data == Integer.valueOf(' '))
                spaces++;
        }

        float rate = (float)spaces/countAll*100;

        DecimalFormat format = new DecimalFormat("#.##");

        System.out.println(format.format(rate));
        fileInputStream.close();
    }
}
