package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        byte[] array1 = new byte[fileInputStream1.available()];
        byte[] array2 = new byte[fileInputStream2.available()];
        byte[] total = new byte[fileInputStream1.available()+fileInputStream2.available()];

        fileInputStream1.read(array1);
        fileInputStream2.read(array2);

        for (int i=0;i<total.length;i++)
        {
            if (i<array2.length)
                total[i] = array2[i];
            else
                total[i] = array1[i-array2.length];
        }

        for (byte b:total)
        System.out.println(b);

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(total);

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
