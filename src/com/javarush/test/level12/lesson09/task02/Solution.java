package com.javarush.test.level12.lesson09.task02;

/* Интерфейсы Fly, Run, Swim
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.
*/

public class Solution {

    interface Fly {
        void fly(String address);
    }

    interface Run {
        void run(String address);
    }

    interface Swim {
        void swim(int time);
    }
}
