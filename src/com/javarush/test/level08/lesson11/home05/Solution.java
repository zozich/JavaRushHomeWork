package com.javarush.test.level08.lesson11.home05;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = s.toUpperCase();
        String result = String.valueOf(s2.charAt(0));
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i - 1)==' ') {
                result += String.valueOf(s2.charAt(i));
            } else {
                result += String.valueOf(s.charAt(i));
            }
        }
        System.out.println(result);
    }
}
