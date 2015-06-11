package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        FileInputStream fileInputStream = new FileInputStream(s);
        while (fileInputStream.available() != 0) {
            int data = fileInputStream.read();
            if (map.containsKey(data))
                map.put(data, map.get(data) + 1);
            else
                map.put(data, 1);
        }
        int max = 0;

        for (Integer i : map.values()) {
            max = max > i ? max : i;
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) == max)
                System.out.print(i + " ");
        }

        fileInputStream.close();
    }
}
