package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int num3 = Integer.parseInt(reader.readLine());
        int midValue = 0;
        if ((num1 >= num2 && num1 <= num3)||(num1 <= num2 && num1 >= num3)) {
            midValue = num1;
        } else if ((num2 >= num1 && num2 <= num3)||(num2 <= num1 && num2 >= num3)) {
            midValue = num2;
        } else if ((num3 >= num1 && num3 <= num2)||(num3 <= num1 && num3 >= num2)) {
            midValue = num3;
        }
        System.out.println(Math.max(Math.max(num1, num2), num3));
        System.out.println(midValue);
        System.out.println(Math.min(Math.min(num1, num2), num3));
    }
}