package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            if (map.containsKey(data))
                map.put(data, map.get(data)+1);
            else
                map.put(data, 1);
        }

        int min = 0;

        for (Integer i:map.values())
        {
            min = (min < i)&&(min!=0) ? min : i;
        }

        for (Integer i: map.keySet())
        {
            if (map.get(i)==min)
                System.out.print(i + " ");
        }

        fileInputStream.close();
    }
}
