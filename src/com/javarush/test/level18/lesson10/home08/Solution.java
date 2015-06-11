package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> files = new ArrayList<String>();
        while (!(fileName = reader.readLine()).equals("exit"))
        {
            files.add(fileName);
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread
    {
        private String fileName;
        private HashMap<Integer, Integer> map;
        private FileInputStream fileInputStream;
        private int maxByte=0;
        private int maxRate=0;

        public ReadThread(String fileName) throws FileNotFoundException
        {
            this.fileName = fileName;
            this.map = new HashMap<Integer, Integer>();
            this.fileInputStream = new FileInputStream(this.fileName);
        }

        @Override
        public void run()
        {
            try
            {
                while (fileInputStream.available()!=0)
                {
                    int data = fileInputStream.read();
                    if (map.containsKey(data))
                        map.put(data, map.get(data)+1);
                    else
                        map.put(data, 1);
                }

                for (Map.Entry<Integer, Integer> i:map.entrySet())
                {
                    if (maxRate<i.getValue())
                    {
                        maxRate = i.getValue();
                        maxByte = i.getKey();
                    }
                }
                synchronized (resultMap)
                {
                    resultMap.put(this.fileName, maxByte);
                }
                this.fileInputStream.close();
            }
            catch (IOException e)
            {
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
