package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1], true);
        while (reader.ready()) {
            String[] array = reader.readLine().split(" ");
            for (String s : array) {
                int count = 0;
                char[] ch = s.toCharArray();
                for (char c : ch) {
                    try {
                        int a = Integer.parseInt(String.valueOf(c));
                        count++;
                    } catch (Exception e) {
                    }
                }
                if (count > 0)
                    writer.write(s + " ");
            }
        }
        reader.close();
        writer.close();
    }
}
