package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        byte[] first = new byte[fileInputStream.available()];
        fileInputStream.read(first);

        String s = new String(first);
        String[] array = s.split(" ");
        double d;
        int[] result = new int[array.length];
        String finish = "";

        for (int i=0;i<array.length;i++)
        {
            d = Double.parseDouble(array[i]);
            result[i] = (int) Math.round(d);
            finish = finish + result[i] + " ";
        }

        finish = finish.substring(0,finish.length()-1);
        byte[] ending = finish.getBytes();
        fileOutputStream.write(ending);

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
