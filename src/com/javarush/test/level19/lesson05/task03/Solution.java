package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        String result="";
        ArrayList<Integer> finalList = new ArrayList<Integer>();

        while (fileReader.ready())
        {
            int data = fileReader.read();
            result += (char)data;
        }
        String[] array1 = result.split("\n");
        for (String s:array1)
        {
            String[] array2 = s.split(" ");
            for (String s2:array2)
            {
                try
                {
                    int i = Integer.parseInt(s2);
                    finalList.add(Integer.parseInt(s2));
                }
                catch (NumberFormatException e)
                {
                }
            }
        }

        result = "";
        for (int i2:finalList)
            result += String.valueOf(i2) + " ";
        result = result.substring(0, result.length()-1);
        char[] toWrite = result.toCharArray();
        fileWriter.write(toWrite);

        fileReader.close();
        fileWriter.close();
    }
}