package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        String result = "";
        int count = 0;
        while (readerF.ready())
        {
            result += readerF.readLine() + " ";
        }
        result = result.replaceAll("\\p{Punct}", " ");
            String[] array2 = result.split(" ");
            for (String s2:array2)
            {
                if (s2.equals("world")) {
                    count++;
                }
            }
        System.out.println(count);
        reader.close();
        readerF.close();
    }
}
