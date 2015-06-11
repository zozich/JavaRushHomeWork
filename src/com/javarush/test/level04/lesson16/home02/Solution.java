package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1 = reader.readLine(), b1 = reader.readLine(), c1 = reader.readLine();
        int a2 = Integer.parseInt(a1), b2 = Integer.parseInt(b1), c2 = Integer.parseInt(c1), d = 0;
        if ((a2>b2 && a2<c2)||((a2<b2 && a2>c2)))
            d = a2;
        else if ((b2>a2 && b2<c2)||((b2<a2 && b2>c2)))
            d = b2;
        else if ((c2>b2 && c2<a2)||((c2<b2 && c2>a2)))
            d = c2;
        System.out.println(d);
    }
}
