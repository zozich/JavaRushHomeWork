package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream orignal = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        String[] array = outputStream.toString().split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);
        int c = 0;
        if (array[1].equals("+"))
            c = a + b;
        if (array[1].equals("-"))
            c = a - b;
        if (array[1].equals("*"))
            c = a*b;
        String result = String.format("%d %s %d = %d", a, array[1], b, c);
        System.setOut(orignal);
        System.out.println(result);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("3 + 6 = ");
        }
    }
}

