package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (fileInputStream.available()!=0)
        {
            int data = fileInputStream.read();
            if (map.containsKey(data))
                map.put(data, map.get(data)+1);
            else
                map.put(data, 1);
        }

        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
        SortArray(list);

        for (int i:list)
            System.out.println((char)i + " " + map.get(i));

        fileInputStream.close();
    }

    public static void SortArray(ArrayList<Integer> list)
    {
        int temp;
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
