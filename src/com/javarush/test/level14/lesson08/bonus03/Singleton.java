package com.javarush.test.level14.lesson08.bonus03;

class Singleton {

    private final static Singleton element = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance()
    {
        return element;
    }
}
