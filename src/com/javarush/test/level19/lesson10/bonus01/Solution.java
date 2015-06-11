package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    private static ArrayList<String> list1 = new ArrayList<String>();
    private static ArrayList<String> list2 = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readFromFile(reader.readLine(), list1);
        readFromFile(reader.readLine(), list2);
        while (!list1.isEmpty()||!list2.isEmpty())
        {
            if (list1.isEmpty()&&!list2.isEmpty())
            {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
                continue;
            }
            if (!list1.isEmpty()&&list2.isEmpty())
            {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
                continue;
            }
            if (list1.get(0).equals(list2.get(0)))
            {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
                continue;
            }
            if (list2.size()>1)
            {
                if (list1.get(0).equals(list2.get(1)))
                {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                    continue;
                }
            }
            if (list1.size()>1)
            {
                if (list2.get(0).equals(list1.get(1)))
                {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                    continue;
                }
            }
        }
        for (LineItem line:lines)
            System.out.println(line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString()
        {
            return type + " " + line;
        }
    }

    public static void readFromFile(String file, List list) throws IOException
    {
        BufferedReader freader = new BufferedReader(new FileReader(file));
        while (freader.ready())
            list.add(freader.readLine());
        freader.close();
    }
}
