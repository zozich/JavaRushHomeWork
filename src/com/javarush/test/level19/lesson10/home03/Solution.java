package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            String[] array = reader.readLine().split(" ");
            String name = "";
            for (int i=0;i<array.length-3;i++)
                name += array[i] + " ";
            name = name.substring(0, name.length()-1);
            GregorianCalendar calendar = new GregorianCalendar();
            int year = Integer.parseInt(array[array.length-1]);
            int month = Integer.parseInt(array[array.length-2])-1;
            int day = Integer.parseInt(array[array.length-3]);
            calendar.set(year, month, day);
            PEOPLE.add(new Person(name, calendar.getTime()));
        }
        reader.close();
    }
}
