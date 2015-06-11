package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Create(fileName, args[1], args[2], args[3]);
        reader.close();
    }

    private static void Create(String fileName, String productName, String price, String quantity) throws IOException
    {
        int id = Incremented(fileName);
        String result = String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        System.out.println(result);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        fileWriter.newLine();
        fileWriter.write(result);
        fileWriter.close();
    }

    private static int Incremented(String fileName) throws IOException
    {
        int max = 0;
        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        while (readerF.ready())
        {
            String s = readerF.readLine();
            if (s.length()<8)
                continue;
            s = s.substring(0, 8);
            s = s.replace(" ", "");
            int id = Integer.parseInt(s);
            max = max > id ? max : id;
        }
        readerF.close();
        return max+1;
    }
}
