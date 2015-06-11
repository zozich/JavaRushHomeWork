package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        int i = Integer.parseInt(reader.readLine());
        for(int j=0;j<i;j++) {
            int a = Integer.parseInt(reader.readLine());
            maximum = a > maximum ? a : maximum;
        }
        System.out.println(maximum);
    }
}
