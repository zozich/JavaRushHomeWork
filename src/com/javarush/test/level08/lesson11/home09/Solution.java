package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 4 2015"));
    }

    public static boolean isDateOdd(String date) {
        Date begin = new Date();
        begin.setMonth(0);
        begin.setDate(1);
        Date transf = new Date(date);
        Long diff = transf.getTime() - begin.getTime();
        return ((diff/1000/60/60/24)%2==0);
    }
}
