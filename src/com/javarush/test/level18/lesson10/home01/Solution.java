package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        char c = 'a';

        int begin = (int) c;
        int[] array = new int[26];

        for (int i=0;i<array.length;i++)
            array[i] = begin + i;

        String[] array2 = new String[26];

        for (int i=0;i<array2.length;i++)
            array2[i] = String.valueOf(((char) array[i]));

        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            for (String s:array2)
            {
                if (s.equals(String.valueOf((char)data).toLowerCase()))
                    count++;
            }
        }

        System.out.println(count);
        fileInputStream.close();
    }
}
