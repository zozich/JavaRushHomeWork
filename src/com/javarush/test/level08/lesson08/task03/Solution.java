package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>()
        {{
                put("Иванов", "Андрей");
                put("Петров", "Андрей");
                put("Сидоров", "Коля");
                put("Козюля", "Андрей");
                put("Павлик", "Сергей");
                put("Сташко", "Андрей");
                put("Шеремета", "Павел");
                put("Климкин", "Павел");
                put("Порошенко", "Петр");
                put("Парцхаладзе", "Гиви");
        }};
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (String s:map.values()) {
            if (s.equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya) {
        int count = 0;
        for (String s:map.keySet()) {
            if (s.equals(familiya)) {
                count++;
            }
        }
        return count;
    }
}
