package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз – ягода, банан – трава, вишня – ягода, груша – фрукт, дыня – овощ, ежевика – куст, жень-шень – корень, земляника – ягода, ирис – цветок, картофель – клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель – клубень
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>()
        {{
                put("арбуз", "ягода");
                put("банан", "трава");
                put("вишня", "ягода");
                put("груша", "фрукт");
                put("дыня", "овощ");
                put("ежевика", "куст");
                put("жень-шень", "корень");
                put("земляника", "ягода");
                put("ирис", "цветок");
                put("картофель", "клубень");
        }};

        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
