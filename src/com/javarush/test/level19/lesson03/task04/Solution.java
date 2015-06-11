package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner original;

        public PersonScannerAdapter(Scanner original)
        {
            this.original = original;
        }

        @Override
        public Person read() throws IOException
        {
            String line = original.nextLine();
            String[] array = line.split(" ");
            String lastName = array[0];
            String firstName = array[1];
            String middleName = array[2];
            int day = Integer.parseInt(array[3]);
            int month = Integer.parseInt(array[4])-1;
            int year = Integer.parseInt(array[5]);
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Date bd = calendar.getTime();
            Person temp = new Person(firstName, middleName, lastName, bd);
            return temp;
        }

        @Override
        public void close() throws IOException
        {
            original.close();
        }
    }
}
