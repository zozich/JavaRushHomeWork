package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int j = Integer.parseInt(reader.readLine());
        int z;
        int NOD = 0;
        z = min(i, j);
        for (int x = 1; x <= z; x++)
        {
            if (i % x == 0 && j % x == 0) {
                NOD = x;
            }
        }
        System.out.println(NOD);
    }

    private static int min(int x, int y)
    {
        return x < y ? x : y;
    }
}
