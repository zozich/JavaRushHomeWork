package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    private static TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    private static ArrayList<Integer> listStart = new ArrayList<Integer>();
    private static ArrayList<Integer> listEnd = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader freader = new BufferedReader(new FileReader(reader.readLine()));
        String result = "";
        while (freader.ready())
            result+=freader.readLine();
        reader.close();
        freader.close();
        proceed(result, args[0]);
    }

    private static void proceed(String result, String tag)
    {
        String resultCopy = new String(result);
        while (resultCopy.indexOf("<" + tag)>=0)
        {
            if (listStart.isEmpty())
                listStart.add(resultCopy.indexOf("<" + tag));
            else
                listStart.add(resultCopy.indexOf("<" + tag) + listStart.get(listStart.size()-1) + tag.length() + 2);
            resultCopy = resultCopy.substring(resultCopy.indexOf("<" + tag) + tag.length()+2);
        }
        resultCopy = new String(result);
        while (resultCopy.indexOf("</" + tag)>=0)
        {
            if (listEnd.isEmpty())
                listEnd.add(resultCopy.indexOf("</" + tag) + tag.length()+3);
            else
                listEnd.add(resultCopy.indexOf("</" + tag) + listEnd.get(listEnd.size()-1) + tag.length() + 3);
            resultCopy = resultCopy.substring(resultCopy.indexOf("</" + tag) + tag.length()+3);
        }
        while (!listStart.isEmpty())
        {
            for (int i = 0; i < listStart.size(); i++)
            {
                if (listStart.get(i) >= listEnd.get(0))
                {
                    map.put(listStart.get(i - 1), listEnd.get(0));
                    listStart.remove(i - 1);
                    listEnd.remove(0);
                    break;
                }
                if (i==listStart.size()-1)
                {
                    map.put(listStart.get(i), listEnd.get(0));
                    listStart.remove(i);
                    listEnd.remove(0);
                }
            }
        }
        for (Map.Entry pair:map.entrySet())
        {
            System.out.println(result.substring((int)pair.getKey(), (int)pair.getValue()));
        }
    }
}
