package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int max = 0;
        FileInputStream fileInputStream = new FileInputStream(s);
        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            max = data > max ? data : max;
        }
        System.out.println(max);
        fileInputStream.close();
    }
}
