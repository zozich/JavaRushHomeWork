package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();
        char[] array = outputStream.toString().toCharArray();
        String result = "";
        for (char c:array)
        {
            try
            {
                result +=Integer.parseInt(String.valueOf(c));
            }
            catch (Exception e)
            {
            }
        }
        System.setOut(original);
        System.out.println(result);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
