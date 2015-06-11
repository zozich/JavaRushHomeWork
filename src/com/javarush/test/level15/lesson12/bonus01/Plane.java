package com.javarush.test.level15.lesson12.bonus01;

public class Plane implements Flyable
{
    int passengers;
    @Override
    public void fly()
    {
    }

    public Plane(int passengers)
    {
        this.passengers = passengers;
    }
}
