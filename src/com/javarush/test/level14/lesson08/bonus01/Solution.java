package com.javarush.test.level14.lesson08.bonus01;

import org.omg.CORBA.ExceptionList;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.acl.AclNotFoundException;
import java.util.*;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.PatternSyntaxException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] i = {0, 1, 2, 3};
            System.out.println(i[5]);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream fis = new FileInputStream("C:/exception.txt");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new RuntimeException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new IOException());
        exceptions.add(new EmptyStackException());
        exceptions.add(new AclNotFoundException());
        exceptions.add(new InputMismatchException());
        exceptions.add(new RejectedExecutionException());
    }
}
