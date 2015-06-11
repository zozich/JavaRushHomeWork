package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    private static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        while (readerF.ready()) {
            String s = readerF.readLine();
            String s2 = s.substring(0, 8).replace(" ", "");
            if (s2.equals(args[1])) {
                if (args[0].equals("-u")) {
                    String[] newList = getName(args);
                    String update = String.format("%-8s%-30s%-8s%-4s", args[1], newList[0], newList[1], newList[2]);
                    list.add(update);
                }
                if (args[0].equals("-d"))
                    continue;
            } else
                list.add(s);
        }
        readerF.close();

        BufferedWriter writerF = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size() - 1; i++) {
            writerF.write(list.get(i));
            writerF.newLine();
        }
        writerF.write(list.get(list.size() - 1));
        writerF.close();
    }

    private static String[] getName(String[] list) {
        String[] newList = new String[3];
        newList[2] = list[list.length - 1];
        newList[1] = list[list.length - 2];
        newList[0] = "";
        for (int i = 0; i < list.length - 4; i++) {
            newList[0] += list[i + 2] + " ";
        }
        newList[0] = newList[0].substring(0, newList[0].length() - 1);
        return newList;
    }
}