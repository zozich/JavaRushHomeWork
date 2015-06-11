package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Alex on 03.01.2015.
 */

public class SubSolution extends Solution
{
    private SubSolution()
    {
        super("");
    }

    private SubSolution(String s)
    {
        super("");
    }

    private SubSolution(int i)
    {
        super(2);
    }

    SubSolution(Integer j)
    {
        super(j);
    }

    SubSolution(boolean s)
    {
        super(s);
    }

    SubSolution(double i)
    {
        super(i);
    }

    protected SubSolution(Object j)
    {
        super(j);
    }

    protected SubSolution(float s)
    {
        super(s);
    }

    protected SubSolution(Double i)
    {
        super(i);
    }

    public SubSolution(Object j, int i)
    {
        super(j, i);
    }

    public SubSolution(float s, int i)
    {
        super(s, i);
    }

    public SubSolution(Double i, int j)
    {
        super(i, j);
    }
}
