package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String principalFileName="";
        TreeMap<Integer, byte[]> treeMap = new TreeMap<Integer, byte[]>();

        while (!(fileName=reader.readLine()).equals("end"))
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            String num = fileName.substring(fileName.lastIndexOf("part")+4, fileName.length());
            int number = Integer.parseInt(num);
            treeMap.put(number, buffer);
            principalFileName = fileName.substring(0, fileName.length()-5-num.length());
        }
        File result = new File(principalFileName);
        result.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(result, true);

        for (byte[] b:treeMap.values())
            fileOutputStream.write(b);

        reader.close();
        fileOutputStream.close();
    }
}
