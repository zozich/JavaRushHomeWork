package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> tempNum = new ArrayList<String>();
        ArrayList<String> tempStr = new ArrayList<String>();

        for (int i=0;i<array.length;i++)
        {
            if (isNumber(array[i]))
                tempNum.add(array[i]);
            else
                tempStr.add(array[i]);
        }

        SortString(tempStr);
        SortNumbers(tempNum);

        int x = 0, y = 0;
        for (int i=0;i<array.length;i++)
        {
            if (isNumber(array[i]))
            {
                array[i] = tempNum.get(x);
                x++;
            }
            else
            {
                array[i] = tempStr.get(y);
                y++;
            }
        }
    }

    public static void SortString(ArrayList<String> list)
    {
        String temp = "";
        for (int i=0;i<list.size()-1;i++)
        {
            for (int j=0;j<list.size()-i-1;j++)
            {
                if (isGreaterThen(list.get(j), list.get(j+1)))
                {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static void Test(ArrayList<String> list)
    {
        for (String x : list)
            System.out.println(x);
        System.out.println();
    }

    public static void SortNumbers(ArrayList<String> list)
    {
        String temp = "";
        for (int i=0;i<list.size()-1;i++)
        {
            for (int j=0;j<list.size()-i-1;j++)
            {
                if (Integer.parseInt(list.get(j + 1))>Integer.parseInt(list.get(j)))
                {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
