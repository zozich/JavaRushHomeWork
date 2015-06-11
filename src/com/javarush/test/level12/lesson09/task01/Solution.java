package com.javarush.test.level12.lesson09.task01;

/* Интерфейс Fly
Напиши свой public интерфейс Fly(летать). Добавь в него два метода.
*/

public class Solution {

    interface Fly {
        void fly(String address);
        void sit(String place);
    }
}
