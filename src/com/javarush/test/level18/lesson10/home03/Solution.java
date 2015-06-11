package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
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
        String file3 = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(file2);
        FileInputStream fileInputStream2 = new FileInputStream(file3);
        FileOutputStream fileOutputStream = new FileOutputStream(file1, true);

        byte[] array1 = new byte[fileInputStream1.available()];
        byte[] array2 = new byte[fileInputStream2.available()];

        fileInputStream1.read(array1);
        fileInputStream2.read(array2);

        fileOutputStream.write(array1);
        fileOutputStream.write(array2);

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
