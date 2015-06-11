package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            if (!list.contains(data))
                list.add(data);
        }
        SortArray(list);
        for (int i:list)
            System.out.print(i + " ");
        fileInputStream.close();
    }

    public static void SortArray(ArrayList<Integer> list)
    {
        int temp = 0;
        for (int i=0;i<list.size()-1;i++)
        {
            for (int j=0;j<list.size()-i-1;j++)
            {
                if (list.get(j)>list.get(j+1))
                {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}
